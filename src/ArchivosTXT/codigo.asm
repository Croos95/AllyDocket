.MODEL SMALL
.STACK 100h
.DATA
resultado_mod DW 0
HOLA DB 10,13 , 'HOLA $'
num DW 29
i DW 0
A DW 20
B DW 10
T0 DW ?
T1 DW ?
.CODE
START:
MOV AX, @DATA
MOV DS, AX
MOV ES, AX
MOV AX, 29
MOV num, AX
MOV AX, 0
MOV i, AX
MOV AX, 20
MOV A, AX
MOV AX, 10
MOV B, AX
MOV AX, 0
MOV resultado_mod, AX
MOV AX, i
CMP AX, BX
JGE GOTO Label1
MOV AX, A
MOV BX, B
MUL BX
MOV T0, AX
MOV AX, T0
MOV i, AX
Label1:
MOV AX, i
CMP AX, BX
JE GOTO Label2
MOV AX, i
SUB AX, B
MOV T1, AX
MOV AX, T1
MOV i, AX
JMP Label1
Label2:
MOV AX, A
CALL PRINT_NUM
MOV AH, 09h
LEA DX, HOLA
INT 21h
CALL PRINT_TEXT
MOV AX, 4C00h
INT 21h
PRINT_NUM:
PUSH AX
PUSH BX
PUSH CX
PUSH DX
MOV BX, 10
MOV CX, 0
MOV DX, 0
DIVIDE:
XOR DX, DX
DIV BX
PUSH DX
INC CX
OR AX, AX
JNZ DIVIDE
PRINT_LOOP:
POP DX
ADD DL, 30h
MOV AH, 05h
INT 21h
LOOP PRINT_LOOP
MOV DL, 0Ah
MOV AH, 02h
INT 21h
MOV DL, 0Dh
MOV AH, 02h
INT 21h
POP DX
POP CX
POP BX
POP AX
RET
PRINT_TEXT:
MOV AH, 05h
INT 21h
RET
END START
