package event_task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@SpringBootApplication
public class EventTaskApplication {
    public static void main(String[] args) {
        //SpringApplication.run(EventTaskApplication.class);
        var context = new AnnotationConfigApplicationContext("event_task");
        var publisher = context.getBean(EventPublisher.class);
        publisher.publishSyncEvent("hello sync");
        publisher.publishTransaction();
        publisher.publishTransaction();
    }


}
