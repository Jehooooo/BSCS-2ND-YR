import Image, ImageDraw

image = Image.new("RGB", (400,400), "white")
draw = ImageDraw.Draw(image)
for i in range(0, 401, 40):
    draw.line([(i,0), (i, 400)], fill ="blue")
    draw.line([(0,i), (400, i) ], fill ="purple")

draw.rectangle([50, 50, 150, 150], outline= "black", fill = "red")
draw.ellipse([200, 50, 300, 150], outline= "black", fill = "green")
draw.polygon([(200, 200,), (250, 300), (150, 300)], fill = "blue")


draw.text((100, 160),   "Red Square", fill = "black")

image.show()
#image.save("shape1.jpg")

# import matplotlib.pyplot as plt
# import matplotlib.patches as patches

# fix, ax = plt.subplots()

# rect = patches.Rectangle((0.1, 0.1), 0.2, 0.2,  facecolor='red', edgecolor='black')
# circle = patches.Circle((0.7, 0.3), 0.15,  facecolor='green', edgecolor='black')
# triangle = patches.Polygon([[0.5, 0.7], [0.6, 0.9], [0.4, 0.9]], closed=True, facecolor='blue')

# ax.add_patch(rect)
# ax.add_patch(circle)
# ax.add_patch(triangle)

# plt.axis('equal')
# plt.axis('off')
# plt.show()++