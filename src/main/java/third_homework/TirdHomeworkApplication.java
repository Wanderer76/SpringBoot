package third_homework;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TirdHomeworkApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(TirdHomeworkApplication.class, args);
        context.getBean(IProfile.class).showProfileInfo();
    }
}
