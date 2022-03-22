package third_homework;

import org.springframework.beans.factory.annotation.Value;

public class ProdBean implements IProfile {

    @Value("${spring.appname}")
    private String Text;

    @Override
    public void showProfileInfo() {
        System.out.println(Text);
    }
}
