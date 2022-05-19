package message_sender;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MessageSenderApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(MessageSenderApplication.class, args);

    }
}
