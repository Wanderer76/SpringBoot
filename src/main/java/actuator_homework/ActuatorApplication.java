package actuator_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActuatorApplication {
    public static void main(String[] args){
        var context = SpringApplication.run(ActuatorApplication.class);
    }
}
