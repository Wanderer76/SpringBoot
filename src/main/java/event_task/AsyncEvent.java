package event_task;

import org.springframework.context.ApplicationEvent;


public class AsyncEvent extends ApplicationEvent {


    public AsyncEvent(Object source) {
        super(source);
        create();
    }

    public String getStatus(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    private void create()
    {
        System.out.println("AsyncEvent - created");
    }

}
