package ru.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.service.Service2;

@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        var context = SpringApplication.run(App.class, args);
        var service2 = context.getBean(Service2.class);
        System.out.println(service2.getApplicationProperties().getId());
    }


}
