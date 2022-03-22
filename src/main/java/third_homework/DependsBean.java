package third_homework;

public class DependsBean {
    private final String TEXT = "Depends Bean";

    DependsBean(){
        showInfo();
    }

    public void showInfo(){
        System.out.println(TEXT);
    }

}
