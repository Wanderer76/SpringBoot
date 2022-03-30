package event_task;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public void publishSyncEvent(String message) {
        applicationEventPublisher.publishEvent(new SyncEvent(this, new Message(message)));
    }

    public void publishAsyncEvent() {
        applicationEventPublisher.publishEvent(new AsyncEvent(this));
    }

    public void publishTransaction() {
        applicationEventPublisher.publishEvent(new TransactionEvent(this));
    }


}
