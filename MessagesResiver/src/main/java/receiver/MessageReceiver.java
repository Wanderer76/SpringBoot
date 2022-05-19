package receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MessageReceiver {
    private final Logger logger = Logger.getLogger("MessageReceiverLogger");
    private static final String MESSAGES_NAME = "best message";

    @JmsListener(destination = MESSAGES_NAME)
    public void processMessage(String message){
        logger.log(Level.INFO,message);
    }


}
