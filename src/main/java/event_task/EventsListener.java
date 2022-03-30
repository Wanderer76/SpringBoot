package event_task;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class EventsListener {

    @EventListener
    public AsyncEvent onSyncEventHandler(SyncEvent event) {
        System.out.println(event.getMessage());
        System.out.println("Sync event processed");
        return new AsyncEvent(event.getSource());
    }

    @EventListener
    @Async
    public void onAsyncEventHandler(AsyncEvent event) {
        System.out.println("Async status " + event.getStatus());
        System.out.println("Async event processed");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onTransactionalEventHandler(TransactionEvent transactionEvent) {
        try {
            transactionEvent.makeTransaction();
            System.out.println("Transactional event processed");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
