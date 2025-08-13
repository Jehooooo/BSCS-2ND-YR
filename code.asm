.data
    prompt1 db "What is your name? $"
    naname db 20, 0, 20 dup('$')  ; First byte: max length, second byte: actual length

    prompt3 db 10, 13, "What is your address? $"
    add db 20, 0, 20 dup('$')      ; Same structure as above

    prompt5 db 10, 13, "What is your course? $"
    course db 20, 0, 20 dup('$')   ; Same structure as above

    prompt7 db 10, 13, "What is your section? $"
    sec db 20, 0, 20 dup('$')      ; Same structure as above

    prompt2 db 10, 13, "Your name is: $"
    prompt4 db 10, 13, "Your address is: $"
    prompt6 db 10, 13, "Your course is: $"
    prompt8 db 10, 13, "Your section is: $"

.code
    assume cs:code, ds:data

start:
    mov ax, data
    mov ds, ax

    ; Ask for name
    mov dx, offset prompt1
    mov ah, 09h
    int 21h

    mov dx, offset naname
    mov ah, 0Ah
    int 21h

    ; Ask for address
    mov dx, offset prompt3
    mov ah, 09h
    int 21h

    mov dx, offset add
    mov ah, 0Ah
    int 21h

    ; Ask for course
    mov dx, offset prompt5
    mov ah, 09h
    int 21h

    mov dx, offset course
    mov ah, 0Ah
    int 21h

    ; Ask for section
    mov dx, offset prompt7
    mov ah, 09h
    int 21h

    mov dx, offset sec
    mov ah, 0Ah
    int 21h

    ; Show results
    mov dx, offset prompt2
    mov ah, 09h
    int 21h

    mov dx, offset naname + 2
    mov ah, 09h
    int 21h

    mov dx, offset prompt4
    mov ah, 09h
    int 21h

    mov dx, offset add + 2
    mov ah, 09h
    int 21h

    mov dx, offset prompt6
    mov ah, 09h
    int 21h

    mov dx, offset course + 2
    mov ah, 09h
    int 21h

    mov dx, offset prompt8
    mov ah, 09h
    int 21h

    mov dx, offset sec + 2
    mov ah, 09h
    int 21h

    ; Exit
    mov ah, 4Ch
    int 21h

code ends
end start