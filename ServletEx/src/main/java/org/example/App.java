package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); //by default it is 8080 only
        try{
            //Creating context and adding the servlet to the context
            Context context = tomcat.addContext("",null);
            Tomcat.addServlet(context,"HelloServlet",new HelloServlet());

            //Doing the mapping
            context.addServletMappingDecoded("/hello","HelloServlet");

            //Starting the server
            tomcat.start();
            tomcat.getServer().await();
        }
        catch (LifecycleException e){
            System.out.println("Tomcat Failed to start");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
