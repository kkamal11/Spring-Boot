package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        //At the very below line only it creates all the object with bean tag
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //this creates one IoC container for us
        Alien al =(Alien) context.getBean("alien");
        System.out.println(al.getAge());
        al.code();

    }
}
