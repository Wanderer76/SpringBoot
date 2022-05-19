package message_sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageSenderController {

    private final JmsTemplate jmsTemplate;
    private static final String MESSAGES_NAME = "best message";

    public MessageSenderController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping(value = "/send",produces = "text/plain")
    public void sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend(MESSAGES_NAME, message);
    }

}
