package edu.escuelaing.arep;
/**
 * la siguiente clase representa un elemento de la linked list denominado como nodo dentro de sus propiedades contiene el valor y el nodo siguiente
 * @author David Ramirez
 * 
 */
public class Nodo{
    private Nodo next;
    private Double value;
    /**
     * Constructor de la clase nodo, sirve para crear un Nodo 
     * @param next indica el nodo que va en la posicion inmediatamente siguiente.
     * @param value indica el valor numerico del elemento.
     */
    public Nodo(Nodo next,Double value){
        this.next=next;
        this.value=value;
    }
    /**
     * funcion que retorna el nodo siguiente a este en la linked list
     * @return Nodo next, el siguiente en la linked list
     */
    public Nodo getNext(){
        return next;
    }
    /**
     * funcion que retorna el valor actual del nodo
     * @return int valor, valor numerico asignado al nodo
     */
    public Double value(){
        return value;
    }
    /**
     * cambia el nodo siguiente a uno nuevo
     * @param node el nodo a definir como siguiente.
     */
    public void setNext(Nodo node){
        next=node;
    }
}