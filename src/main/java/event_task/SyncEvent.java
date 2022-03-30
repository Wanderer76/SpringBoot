package event_task;

import org.springframework.context.ApplicationEvent;


public class SyncEvent extends ApplicationEvent {
    private final Message message;

    public SyncEvent(Object source, Message message) {
        super(source);
        this.message = message;
        create();
    }

    public String getMessage() {
        return message.getMessage();
    }

    private void create()
    {
        System.out.println("SyncEvent - created");
    }
}
