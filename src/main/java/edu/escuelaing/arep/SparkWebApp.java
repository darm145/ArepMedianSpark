package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku"); 
        post("/asd", (req,res) ->{
            return ("Request body"+req.body()+"\n Response Body"+res.body());
        });
        post("/media",(req,res)-> {

            String[] values=req.body().split(" ");
            LinkedList list=new LinkedList();
            for(String i: values){
                
                list.insertar(Double.parseDouble(i));
                
            }
            
            return MedianStandard.media(list);
        });
        post("/desviacion",(req,res)-> {

            String[] values=req.body().split(" ");
            LinkedList list=new LinkedList();
            for(String i: values){
                
                list.insertar(Double.parseDouble(i));
                
            }
            
            return MedianStandard.desviacion(list);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        // returns default port if heroku-port isn't set (i.e. on localhost)

    }
}