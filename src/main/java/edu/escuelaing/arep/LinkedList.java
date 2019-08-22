package edu.escuelaing.arep;
/**
 * implementacion de una linked list simple 
 * @author David Ramirez
 */
public class LinkedList{
    private static Nodo head;
    public LinkedList(){
        head=null;
    }
    /**
     * metodo para obtener el item que se encuentra en la primera posicion de la linked list
     * @return head el primero elemento de la linked list
     */
    public Nodo getHead(){
        return head;
    }
    /**
     * metodo para insertar un elemento al final de la linked list
     * @param value el valor del elemento a insertar en la linked list
     */
    public  void insertar(Double value){
        if (head==null){
            head= new Nodo(null,value);
        }
        else{
            Nodo temp= head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            Nodo nuevo=new Nodo(null,value);
            temp.setNext(nuevo);
        }
        
    }
    /**
     * metodo para eliminar un elemento de la linked list 
     * @param value el valor del elemento a eliminar de la linked list
     */
    public  void eliminar(float value){
        boolean eliminado=false;
        if(head!=null){
            if(head.value()==value){
                head=head.getNext();
                eliminado=true;
            }
            else{
                Nodo actual= head.getNext();
                Nodo anterior=head;
                while(actual !=null){
                    if(actual.value()==value){
                        anterior.setNext(actual.getNext());
                        eliminado =true;
                        break;
                    }
                actual=actual.getNext();
                anterior=anterior.getNext();
                }
            }
        }
        if (eliminado){
            System.out.println("elemento eliminado");
        }
        else{
            System.out.println("no se encontro el elemento");
        }
    }
    /**
     * metodo que imprime en pantalla los datos contenidos en la linked list
     */
    public  void verDatos(){
        Nodo actual=head;
        while(actual!=null){
            System.out.print(actual.value()+" ");
            actual=actual.getNext();
        }
        System.out.println();
    }
}