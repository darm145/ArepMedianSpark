package edu.escuelaing.arep;

import static spark.Spark.*;

import javax.print.attribute.standard.Media;

import spark.Request;
import spark.Response;

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
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Median an Standard deviation Calculator</h2>"
                + "<form action=\"/results\">"
                + "  please insert the data separated by a blank space :<br>"
                + "  <input type=\"text\" name=\"Numeros\" value=\"\">"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Calculate\">"
                + "</form>"
                + "<p>Al select the  \"Calculate\" button to display the results in the page  \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        String[] values=req.queryParams("Numeros").split(" ");
            LinkedList list=new LinkedList();
            for(String i: values){
                list.insertar(Double.parseDouble(i));
            }
        
        return "The median of the inserted data is:"+ MedianStandard.media(list) +" and standard deviation is:"+MedianStandard.desviacion(list) ;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        // returns default port if heroku-port isn't set (i.e. on localhost)

    }
}