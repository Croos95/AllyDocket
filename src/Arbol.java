
import compilerTools.Production;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * Cortez Salinas Arath de Jesús Cortez Salinas - 5B
 */
public class Arbol {

    Stack<Nodo> arbolNodo;
    Stack<String> caracter; //Identificar si es operador o operando
    final String espacios = "\t";
    final String aritmeticos = "+-*/";
    final String variables = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Obtener la fecha actual
    public LocalDate fechaActual = LocalDate.now();
    private Nodo raiz;
    //27 Jun
    HashMap<String, String> reglasSemanticas;
    HashMap<String, String> tablaSimbolos;
    HashMap<String, String> erroresSemanticos;
    public ArrayList<String> valores;
    int paso;
    String[] temporal = {"T1", "T2"};
    Compilador cmp = new Compilador();
    //Constructors
    public Arbol() {
        tablaSimbolos = new HashMap<>();
        erroresSemanticos = new HashMap<>();
        arbolNodo = new Stack<Nodo>();
        caracter = new Stack<String>();
        valores = new ArrayList<String>();
        reglasSemanticas = new HashMap<>();
        agregarReglasSemanticas();
        getReglasSemanticas();
    }//Constructor
    //Avanxe 27/Jun/2024

    public void agregarReglasSemanticas() {
        reglasSemanticas.put("rs1", "E.nodo = new Nodo ('+' , E1.nodo. , T.nodo)");
        reglasSemanticas.put("rs2", "E.nodo = new Nodo ('-' , E.nodo , T.nodo)");
        reglasSemanticas.put("rs3", "E.nodo =  T.nodo");
        reglasSemanticas.put("rs4", "T.nodo =  E.nodo");
        reglasSemanticas.put("rs5", "T.nodo = new Hoja(id, id.entrada)");
        reglasSemanticas.put("rs3", "T.nodo = new Hoja(num ,num.id )");
    }//metodo de reglas semanticas

    public String getReglasSemanticas() {
        String cadena = "";
        for (String i : reglasSemanticas.keySet()) {
            cadena += "key: " + i + "regla semantica: " + reglasSemanticas.get(i) + "\n";
        }
        return cadena;
    }
    //--------------------------------------------------------------------//
    //Avance 24/06/2024

    public void agregaValex(String id, String valor) {
        this.tablaSimbolos.put(id, valor);
    }//agregaValex Léxico  

    public String regresaValex(String lexema) {
        return this.tablaSimbolos.get(lexema);
    }

    public void guardar() {//Permite construir el árbol
        Nodo izquierdo = (Nodo) arbolNodo.pop();
        Nodo derecho = (Nodo) arbolNodo.pop();
        System.out.println("Construyendo sub-arbol");
        System.out.println("Dato izquierdo---> " + izquierdo.getDato());
        System.out.println("Dato derecho-----> " + derecho.getDato());
        System.out.println("Caracter---------> " + caracter.peek());
        arbolNodo.push(new Nodo(derecho, caracter.pop(), izquierdo));
    }

    //El método "crear", permitira separar en tokens 
    //identificar entre OPERANDOS Y OPERADORES
    //Para construir el Árbol de Expresion(árbol binario).
    public Nodo crear() {
        //Declaracion de Variables
        for (Production id : cmp.identProd) {
            String tipoDato = id.lexemeRank(0);
            String valorAsignado = id.lexemeRank(3);
            System.out.println(tipoDato+ " , " + valorAsignado);
        } 
        //Declaracion de Variables
        return null;
    }
}
