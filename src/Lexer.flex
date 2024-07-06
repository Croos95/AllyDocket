import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables basicas */

TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/" [^] ~"/" | "/" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^] | \+ [^/] )
ComentarioDeDocumentacion = "/" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
L = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
D = [0-9]
IDENTIFICADOR = {L}({L}|{D})*
/*Cadena*/
L=[A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
D=[0-9]
/* Número */
NUMERO = 0|[+-]?([1-9][0-9]*)



/* Definición de macros para caracteres válidos */
Igualdad = "=="
Desigualdad = "!="
MayorQue = ">>"
MenorQue = "<<"
MayorIgualQue = ">="
MenorIgualQue = "<="
AndLogico = "&&"
OrLogico = "||"
NotLogico = "!"
Asignacion = "="
Incremento = "\'+"
Decremento = "\'-"
Suma = "++"
Resta = "--"
Multiplicacion = "**"
Division = "//"
Modulo = "%%"
ParA = "("
ParC = ")"
CorA = "{"
CorC = "}"
ParCuaA = "["
ParCuaC = "]"
Decimal = "."
FinLinea = ";"
Separador = ","
Comilla = "\""
ComillaS = "'"
Dinero = "$"
ComillaD = "\""
Gbajo = "_"
Sep = "&"

/* Combinación de macros en CaracteresValidos */
CaracteresValidos = {Sep}|{Gbajo} |{Igualdad} | {Desigualdad} | {MayorQue} | {MenorQue} | {MayorIgualQue} | {MenorIgualQue} | {AndLogico} | {OrLogico} | {NotLogico} | {Asignacion} | {Incremento} | {Decremento} | {Suma} | {Resta} | {Multiplicacion} | {Division} | {Modulo} | {ParA} | {ParC} | {CorA} | {CorC} | {ParCuaA} | {ParCuaC} | {Decimal} | {FinLinea} | {Separador} | {Comilla} | {ComillaS} | {Dinero} | {ComillaD}

/* Definición de la macro para palabras reservadas */
/*Bloque de código*/
VARIABLES = "VARIABLES"
PROCESOS = "PROCESOS"
/*Operaciones básicas*/
SUMA = "SUMA"
RESTA = "RESTA"
MULTIPLICACION = "MULTIPLICACION"
DIVISION = "DIVISION"
MODULO = "MODULO"
/*Operaciones avanzadas*/
POTENCIA = "POTENCIA"
RAIZ_CUADRADA = "RAIZ_C"
RAIZ_ENESIMA = "RAIZ_N"
LOGARITMO_NATURAL = "LN"
LOGARITMO_BASE_10 = "LOG10"
EXPONENCIAL = "EXP"
/*Operaciones trigonométricas*/
SENO = "SEN"
COSENO = "COS"
TANGENTE = "TAN"
ARCOSENO = "ARCSEN"
ARCOCOSENO = "ARCCOS"
ARCOTANGENTE = "ARCTAN"
SENO_HIPERBOLICO = "SEN_H"
COSENO_HIPERBOLICO = "COS_H"
TANGENTE_HIPERBOLICA = "TAN_H"
/*Funciones matemáticas*/
VALOR_ABSOLUTO = "ABS"
FACTORIAL = "FACT"
REDONDEO = "REDONDEO"
REDONDEO_HACIA_ABAJO = "REDONDEO_MENOS"
REDONDEO_HACIA_ARRIBA = "REDONDEO_MAS"
MAXIMO_COMUN_DIVISOR = "MCD"
MINIMO_COMUN_MULTIPLO = "MCM"
/*Comparación*/
IGUAL_A="IGUAL_A"
DIFERENTE_DE="DIFERENTE_DE"
MAYOR_QUE="MAYOR_QUE"
MENOR_QUE="MENOR_QUE"
MAYOR_O_IGUAL_QUE="MAYOR_O_IGUAL_QUE"
MENOR_O_IGUAL_QUE="MENOR_O_IGUAL_QUE"
/*Operaciones de estadísticas*/
MEDIANA = "MEDIANA"
VARIANZA = "VAR"
DESVIACION_ESTANDAR = "DESVESTA"
PROMEDIO = "PROMEDIO"
ROMPER="ROMPER"
/*ESTRUCTURAS*/
SI = "SI"
REPETIR ="REPETIR"
MIENTRAS ="MIENTRAS"
verdadero = "verdadero"
falso = "falso"
/*Salida de texto*/
IMPRIMIR = "IMPRIMIR"
ASIGNAR = "ASIGNAR"
SINO = "SINO"
/* Definición de la macro para palabras reservadas */
PalabrasReservadas ={ROMPER}|{SINO}|{ASIGNAR}|{IMPRIMIR}|{falso}|{verdadero}|{MIENTRAS}|{REPETIR}|{SI}|{MENOR_O_IGUAL_QUE}|{MAYOR_O_IGUAL_QUE}|{MENOR_QUE}|{MAYOR_QUE}|{DIFERENTE_DE}|{IGUAL_A}|{VARIABLES}|{PROCESOS}|{SUMA}|{RESTA}|{MULTIPLICACION}|{DIVISION}|{MODULO}|{POTENCIA}|{RAIZ_CUADRADA}|{RAIZ_ENESIMA}|{LOGARITMO_NATURAL}|{LOGARITMO_BASE_10}|{EXPONENCIAL}|{SENO}|{COSENO}|{TANGENTE}|{ARCOSENO}|{ARCOCOSENO}|{ARCOTANGENTE}|{SENO_HIPERBOLICO}|{COSENO_HIPERBOLICO}|{TANGENTE_HIPERBOLICA}|{VALOR_ABSOLUTO}|{FACTORIAL}|{REDONDEO}|{REDONDEO_HACIA_ABAJO}|{REDONDEO_HACIA_ARRIBA}|{MAXIMO_COMUN_DIVISOR}|{MINIMO_COMUN_MULTIPLO}|{MEDIANA}|{VARIANZA}|{DESVIACION_ESTANDAR}|{PROMEDIO}

%%

{CaracteresValidos} 
{
    switch (yytext()) {
        case "&" :return token(yytext(), "SEP", yyline, yycolumn);
        case "_" :return token(yytext(), "GBAJO", yyline, yycolumn);
        case "==": return token(yytext(), "IGUALDAD", yyline, yycolumn);
        case "!=": return token(yytext(), "DESIGUALDAD", yyline, yycolumn);
        case ">>": return token(yytext(), "MAYORQUE", yyline, yycolumn);
        case "<<": return token(yytext(), "MENORQUE", yyline, yycolumn);
        case ">=": return token(yytext(), "MAYORIGUALQUE", yyline, yycolumn);
        case "<=": return token(yytext(), "MENORIGUALQUE", yyline, yycolumn);
        case "&&": return token(yytext(), "ANDLOGICO", yyline, yycolumn);
        case "||": return token(yytext(), "ORLOGICO", yyline, yycolumn);
        case "!": return token(yytext(), "NOTLOGICO", yyline, yycolumn);
        case "=": return token(yytext(), "ASIGNACION", yyline, yycolumn);
        case "\'+": return token(yytext(), "INCREMENTO", yyline, yycolumn);
        case "\'-": return token(yytext(), "DECREMENTO", yyline, yycolumn);
        case "++": return token(yytext(), "SUMA", yyline, yycolumn);
        case "--": return token(yytext(), "RESTA", yyline, yycolumn);
        case "**": return token(yytext(), "MULTIPLICACION", yyline, yycolumn);
        case "//": return token(yytext(), "DIVISION", yyline, yycolumn);
        case "%%": return token(yytext(), "MODULO", yyline, yycolumn);
        case "(": return token(yytext(), "PARA", yyline, yycolumn);
        case ")": return token(yytext(), "PARC", yyline, yycolumn);
        case "{": return token(yytext(), "CORA", yyline, yycolumn);
        case "}": return token(yytext(), "CORC", yyline, yycolumn);
        case "[": return token(yytext(), "PARCUAA", yyline, yycolumn);
        case "]": return token(yytext(), "PARCUAC", yyline, yycolumn);
        case ".": return token(yytext(), "PUNTODECIMAL", yyline, yycolumn);
        case ";": return token(yytext(), "FINLINEA", yyline, yycolumn);
        case ",": return token(yytext(), "SEPARADOR", yyline, yycolumn);
        case "\"": return token(yytext(), "COMILLA", yyline, yycolumn);
        case "'": return token(yytext(), "COMILLASIMPLE", yyline, yycolumn);
        case "$": return token(yytext(), "DINERO", yyline, yycolumn);
    }
}

/* Switch para acceder a cada palabra reservada */
{PalabrasReservadas} {
    switch(yytext()) {
        case "VARIABLES": return token(yytext(), "VARIABLES", yyline, yycolumn);
        case "PROCESOS": return token(yytext(), "PROCESOS", yyline, yycolumn);
        /* Operaciones básicas */
        case "SUMA": return token(yytext(), "SUMA", yyline, yycolumn);
        case "RESTA": return token(yytext(), "RESTA", yyline, yycolumn);
        case "MULTIPLICACION": return token(yytext(), "MULTIPLICACION", yyline, yycolumn);
        case "DIVISION": return token(yytext(), "DIVISION", yyline, yycolumn);
        case "MODULO": return token(yytext(), "MODULO", yyline, yycolumn);
        /* Operaciones avanzadas */
        case "POTENCIA": return token(yytext(), "POTENCIA", yyline, yycolumn);
        case "RAIZ_C": return token(yytext(), "RAIZ_CUADRADA", yyline, yycolumn);
        case "RAIZ_N": return token(yytext(), "RAIZ_ENESIMA", yyline, yycolumn);
        case "LN": return token(yytext(), "LOGARITMO_NATURAL", yyline, yycolumn);
        case "LOG10": return token(yytext(), "LOGARITMO_BASE_10", yyline, yycolumn);
        case "EXP": return token(yytext(), "EXPONENCIAL", yyline, yycolumn);
        /* Operaciones trigonométricas */
        case "SEN": return token(yytext(), "SENO", yyline, yycolumn);
        case "COS": return token(yytext(), "COSENO", yyline, yycolumn);
        case "TAN": return token(yytext(), "TANGENTE", yyline, yycolumn);
        case "ARCSEN": return token(yytext(), "ARCOSENO", yyline, yycolumn);
        case "ARCCOS": return token(yytext(), "ARCOCOSENO", yyline, yycolumn);
        case "ARCTAN": return token(yytext(), "ARCOTANGENTE", yyline, yycolumn);
        case "SEN_H": return token(yytext(), "SENO_HIPERBOLICO", yyline, yycolumn);
        case "COS_H": return token(yytext(), "COSENO_HIPERBOLICO", yyline, yycolumn);
        case "TAN_H": return token(yytext(), "TANGENTE_HIPERBOLICA", yyline, yycolumn);
        /* Funciones matemáticas */
        case "ABS": return token(yytext(), "VALOR_ABSOLUTO", yyline, yycolumn);
        case "FACT": return token(yytext(), "FACTORIAL", yyline, yycolumn);
        case "REDONDEO": return token(yytext(), "REDONDEO", yyline, yycolumn);
        case "REDONDEO_MENOS": return token(yytext(), "REDONDEO_HACIA_ABAJO", yyline, yycolumn);
        case "REDONDEO_MAS": return token(yytext(), "REDONDEO_HACIA_ARRIBA", yyline, yycolumn);
        case "MCD": return token(yytext(), "MAXIMO_COMUN_DIVISOR", yyline, yycolumn);
        case "MCM": return token(yytext(), "MINIMO_COMUN_MULTIPLO", yyline, yycolumn);
        /*Comparación*/
        case "IGUAL_A": return token(yytext(), "IGUAL_A", yyline, yycolumn);
        case "DIFERENTE_QUE": return token(yytext(), "DIFERENTE_QUE", yyline, yycolumn);
        case "MAYOR_QUE" : return token(yytext(), "MAYOR_QUE", yyline, yycolumn);
        case "MENOR_QUE" : return token(yytext(), "MENOR_QUE", yyline, yycolumn);
        case "MAYOR_O_IGUAL_QUE": return token(yytext(), "MAYOR_O_IGUAL_QUE", yyline, yycolumn);
        case "MENOR_O_IGUAL_QUE": return token(yytext(), "MENOR_O_IGUAL_QUE", yyline, yycolumn);
        /* Operaciones de estadísticas */
        case "MEDIANA": return token(yytext(), "MEDIANA", yyline, yycolumn);
        case "VAR": return token(yytext(), "VAR", yyline, yycolumn);
        case "DESVESTA": return token(yytext(), "DESVIACION_ESTANDAR", yyline, yycolumn);
        case "PROMEDIO": return token(yytext(), "PROMEDIO", yyline, yycolumn);
        case "SI": return token(yytext(), "SI", yyline, yycolumn);
        case "REPETIR": return token(yytext(), "REPETIR", yyline, yycolumn);
        case "MIENTRAS": return token(yytext(), "MIENTRAS", yyline, yycolumn);
        case "verdadero": return token(yytext(), "VERDADERO", yyline, yycolumn);
        case "falso": return token(yytext(), "FALSO", yyline, yycolumn);
        case "IMPRIMIR": return token(yytext(), "IMPRIMIR", yyline, yycolumn);
        case "ASIGNAR": return token(yytext(), "ASIGNAR", yyline, yycolumn);
        case "SINO": return token(yytext(), "SINO", yyline, yycolumn);
        case "ROMPER": return token(yytext(), "ROMPER", yyline, yycolumn);
    }
}



/* Definición de caracteres inválidos (cualquier cosa que no sea Cadena, CaracteresValidos, Comentario, EspacioEnBlanco o Numero) */
/* Identificador */

"#" {IDENTIFICADOR}  { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }
/*Tipo de Datos*/
ENTERO { return token(yytext(), "ENTERO", yyline, yycolumn); }
BOOLEANO { return token(yytext(), "BOOLEANO", yyline, yycolumn); }
DECIMAL { return token(yytext(), "DECIMAL", yyline, yycolumn); }
TEXTO { return token(yytext(), "TEXTO", yyline, yycolumn); }
{Comilla}({IDENTIFICADOR}|{EspacioEnBlanco}|.|,|:|;)*{Comilla} { return token(yytext(), "CADENA", yyline, yycolumn); }
/* Comentarios o espacios en blanco */

{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

{NUMERO} { return token(yytext(), "NUMERO", yyline, yycolumn); }
{NUMERO}{Decimal}{NUMERO} { return token(yytext(), "NDECIMAL", yyline, yycolumn); }

/* Regla para errores */
   . |{IDENTIFICADOR}  {return token(yytext(), "ERROR_1", yyline, yycolumn); }

