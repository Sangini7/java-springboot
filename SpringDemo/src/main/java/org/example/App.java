package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj = (Alien)context.getBean("alien");
//        obj.code();

        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        Alien alien=  context.getBean( Alien.class);
//        Alien alien = new Alien(context.getBean( Computer.class), 21);
        alien.code();
//        Desktop dt=  context.getBean("desktop", Desktop.class);
//        dt.compile();;

    }
}
