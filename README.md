# Mean and Standard Deviation using Linked Lists  
# Author : David Daniel A. Ramirez Moreno
## Architecture
![](images/diagrama.jpg)  
on the following image we can make a break down of the architecture presented on the project.  
as we can see we have 3 classes, linked List, Node And MedianStandard
### MedianStandard
this class consist of the methods that allow us to calculate the mean and the standard deviation on the project this method receive as parameter the linked list from wich we are going to extract the data and make the calculations needed.  
the mean and standard deviation formulas are the following:  
![](images/formulas.png)  
### LinkedList
this class is focused on the management of the data using Node class wich will be explained later. with this class we can do the following operations to manage the data:  
1. insert a value, this will create a Node and insert it on the tail of the linkedList.
2. delete a value, this will find the first matching value with the data given an remove it from the LinkedList.
3. check the data of the linked list, this will allow to navigate through the linked list and retreive the data it contains.  


### Node
 the node is the simplest class of the project, it contains the value it is saving and a reference to the next node in order to navigate through them.  

 here is an example of the linked list we are working on where we can found how it and the node works:  
![](images/ll.png)  

## Deployment 
![](images/despliege.png)  
here we can find the deployment diagram, as we can notice the user can access the program using his own web browser, on the web browser he enters to the Application wich is hosted on the Cloud Service Heroku via Link.  
after entering to the heroku page where the Application is hosted he can use it, first of all heroku will show him the web page created by spark on the SparkWebAPP file, then the user will insert the data following the parameters given, after that the MedianStandard file will manage the data along with the LinkedList and the Node to finally reply to the user.

## Running the project
to run the project you must execute the following commands on the root folder:  
> mvn package  

and then:  
> mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.MedianStandard"  
## Javadocs
the javadocs can be found in the folder :  
> Javadocs

## Executing a query to the heroku server
we can make a request via web by entering the heroku link:  
> https://medianspark.herokuapp.com/inputdata  

then we insert the data separated by a blank space and the decimal numbers must be writen with a point(.) instead of a comma(,), for example:  
![](images/test1.png)  
and the result:  
![](images/test2.png)  
also to execute a query with the method post to the heroku server we must follow the next structure:  
for the media:  
> curl -i -X POST -H 'Content-Type: text/plain' -d '{insert here the numbers separated by a blank space}' https://medianspark.herokuapp.com/media  

and for the standard deviation:  
> curl -i -X POST -H 'Content-Type: text/plain' -d '{insert here the numbers separated by a blank space}' https://medianspark.herokuapp.com/desviacion 

here is an example:  
![](images/consulta.png)  





