/* Utilities */
const qs = (sel, ctx = document) => ctx.querySelector(sel);
const qsa = (sel, ctx = document) => Array.from(ctx.querySelectorAll(sel));

/* Year in footer */
qs('#year').textContent = new Date().getFullYear();

/* Mobile nav toggle */
const menuToggle = qs('#menu-toggle');
const nav = qs('#site-nav');
menuToggle.addEventListener('click', () => {
  const open = nav.classList.toggle('open');
  menuToggle.setAttribute('aria-expanded', open ? 'true' : 'false');
});
qsa('.nav-link').forEach(link => link.addEventListener('click', () => {
  nav.classList.remove('open');
  menuToggle.setAttribute('aria-expanded', 'false');
}));

/* Smooth scroll */
qsa('a[href^="#"]').forEach(a => {
  a.addEventListener('click', e => {
    const id = a.getAttribute('href').slice(1);
    const el = qs('#' + CSS.escape(id));
    if (el) {
      e.preventDefault();
      el.scrollIntoView({ behavior: 'smooth', block: 'start' });
      history.replaceState(null, '', '#' + id);
    }
  });
});

/* Scroll reveal */
const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('in');
      observer.unobserve(entry.target);
    }
  });
}, { threshold: 0.12 });

qsa('.section, .glow-card, .project-card').forEach(el => {
  el.classList.add('reveal');
  observer.observe(el);
});

/* Skill meters */
qsa('.meter').forEach(m => {
  const value = Number(m.getAttribute('data-value')) || 0;
  m.style.setProperty('--w', value + '%');
});

/* Tilt effect for project cards (desktop only) */
const isTouch = matchMedia('(hover: none), (pointer: coarse)').matches;
if (!isTouch) {
  qsa('.tilt').forEach(card => {
    const rect = () => card.getBoundingClientRect();
    const dampen = 40;
    card.addEventListener('mousemove', (e) => {
      const r = rect();
      const cx = r.left + r.width / 2;
      const cy = r.top + r.height / 2;
      const dx = (e.clientX - cx) / r.width;
      const dy = (e.clientY - cy) / r.height;
      const rx = (+dy * dampen).toFixed(2);
      const ry = (-dx * dampen).toFixed(2);
      card.style.transform = `perspective(900px) rotateX(${rx}deg) rotateY(${ry}deg)`;
    });
    card.addEventListener('mouseleave', () => {
      card.style.transform = 'perspective(900px) rotateX(0deg) rotateY(0deg)';
    });
  });
}

/* Scroll to top */
const scrollTopBtn = qs('#scrollTop');
const onScroll = () => {
  if (window.scrollY > 320) {
    scrollTopBtn.classList.add('show');
  } else {
    scrollTopBtn.classList.remove('show');
  }
};
window.addEventListener('scroll', onScroll, { passive: true });
scrollTopBtn.addEventListener('click', () => window.scrollTo({ top: 0, behavior: 'smooth' }));

/* Particles Canvas Background */
(() => {
  const canvas = qs('#particles');
  const ctx = canvas.getContext('2d');
  let width, height, dpr, particles, rafId;

  const prefersReduced = matchMedia('(prefers-reduced-motion: reduce)').matches;
  const maxParticles = prefersReduced ? 40 : 110;

  function resize() {
    dpr = Math.min(window.devicePixelRatio || 1, 2);
    width = canvas.width = Math.floor(innerWidth * dpr);
    height = canvas.height = Math.floor(innerHeight * dpr);
    canvas.style.width = innerWidth + 'px';
    canvas.style.height = innerHeight + 'px';
  }

  function createParticles() {
    particles = new Array(maxParticles).fill(0).map(() => ({
      x: Math.random() * width,
      y: Math.random() * height,
      vx: (Math.random() - 0.5) * 0.25 * dpr,
      vy: (Math.random() - 0.5) * 0.25 * dpr,
      r: (Math.random() * 1.8 + 0.6) * dpr,
      c: Math.random() < 0.33 ? '#00eaff' : (Math.random() < 0.66 ? '#b968ff' : '#00ffa3')
    }));
  }

  function step() {
    ctx.clearRect(0, 0, width, height);

    // glow composite
    ctx.globalCompositeOperation = 'lighter';

    for (let i = 0; i < particles.length; i++) {
      const p = particles[i];
      p.x += p.vx; p.y += p.vy;

      if (p.x < 0 || p.x > width) p.vx *= -1;
      if (p.y < 0 || p.y > height) p.vy *= -1;

      ctx.beginPath();
      ctx.fillStyle = p.c;
      ctx.shadowColor = p.c;
      ctx.shadowBlur = 16 * dpr;
      ctx.arc(p.x, p.y, p.r, 0, Math.PI * 2);
      ctx.fill();
    }

    // Connect close particles
    for (let i = 0; i < particles.length; i++) {
      for (let j = i + 1; j < particles.length; j++) {
        const a = particles[i], b = particles[j];
        const dx = a.x - b.x, dy = a.y - b.y;
        const dist2 = dx * dx + dy * dy;
        const maxDist = 120 * dpr;
        if (dist2 < maxDist * maxDist) {
          const t = 1 - Math.sqrt(dist2) / (maxDist);
          ctx.beginPath();
          ctx.moveTo(a.x, a.y);
          ctx.lineTo(b.x, b.y);
          ctx.strokeStyle = 'rgba(0, 234, 255, ' + (0.12 + t * 0.25) + ')';
          ctx.lineWidth = 1 * dpr;
          ctx.stroke();
        }
      }
    }

    rafId = requestAnimationFrame(step);
  }

  function start() {
    cancelAnimationFrame(rafId);
    resize();
    createParticles();
    step();
  }

  window.addEventListener('resize', start);
  start();
})();