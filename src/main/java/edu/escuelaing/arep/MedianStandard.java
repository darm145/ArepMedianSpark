package edu.escuelaing.arep;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * implementacion de un programa que permite calcular media y desviacion estandar de ciertos datos.
 *@author David Ramirez
 */
public class MedianStandard 

{
    
    
    /**
     * metodo que permite obtener la media y la desviacion estandar de un archivo de texto con los datos
     * @param path direccion del archivo a leer
     * @return Double[] results, lista de Double donde en la primera casilla se encuentra la media y en la segunda se encuentra la desviacion
     */
    public static Double[] getResults(String path) throws FileNotFoundException{
        LinkedList elementos = new LinkedList();
        Scanner sc= new Scanner(new File(path));
        while(sc.hasNextDouble()){
            elementos.insertar(sc.nextDouble());
        }
        sc.close();
        Double[] results={media(elementos),desviacion(elementos)};
        return results;
        
    }
    /**
     * permite ver los datos actualmente almacenados.
     *  @param elementos linked list con los elementos
     */
    private static void verDatos(LinkedList elementos) {
        elementos.verDatos();
    }
    /**
     * permite eliminar un dato de la linked list
     * @param value el dato a eliminar 
     *  @param elementos linked list con los elementos
     */
    private static void eliminar(float value,LinkedList elementos) {
        elementos.eliminar(value);
    }
    /**
     * permite insertar un dato de la linked list
     * @param value el dato a insertar
     *  @param elementos linked list con los elementos
     */

    private static void insertar(Double value,LinkedList elementos) {
        elementos.insertar(value);
    }
    /**
     * metodo para calcular la media de los elementos
     * @param elementos linked list con los elementos
     * @return el valor de la media para los elementos recibidos
     */
    public static Double media(LinkedList elementos) {
        Double valores=0.0;
        Double sumatoria=0.0;
        Nodo actual=elementos.getHead();
        while (actual!=null){
            valores+=1;
            sumatoria+=actual.value();
            actual=actual.getNext();
        }
        Double resultado=sumatoria/valores;
        return resultado;
    }
    /**
     * permite calcular la desviacion estandar de los datos ingresados
     *  @param elementos linked list con los elementos
     * @return el valor de la desviacion estandar de los datos ingresados
     */
    public static Double desviacion(LinkedList elementos){
        Double media=media(elementos);
        Double sumatoria=0.0;
        Nodo actual=elementos.getHead();
        Double valores=-1.0;
        DecimalFormat df= new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        
        while (actual!=null){
            
            valores+=1;
            sumatoria+=(actual.value()-media)*(actual.value()-media);
            actual=actual.getNext();
        }
        
        return Double.parseDouble(df.format(Math.sqrt(sumatoria/valores)).replace(",", "."));
    }
}
