package third_homework;

import org.springframework.beans.factory.annotation.Value;


public class TestBean implements IProfile {

    @Value("${spring.appname}")
    private String appname;

    @Override
    public void showProfileInfo() {
        System.out.println(appname);
    }
}