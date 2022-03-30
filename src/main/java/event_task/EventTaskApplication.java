package event_task;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventTaskApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("event_task");
        var publisher = context.getBean(EventPublisher.class);
        publisher.publishSyncEvent("hello sync");
        publisher.publishTransaction();
        publisher.publishTransaction();
    }


}
