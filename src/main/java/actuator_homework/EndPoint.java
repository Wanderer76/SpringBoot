package actuator_homework;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@RestControllerEndpoint(id="custom-end-point")
public class EndPoint {
    private static int requestCount = 0;
    private final Logger logger = Logger.getLogger("myLogger");

    @GetMapping("/request_count")
    public ResponseEntity getRequestCount(){
        requestCount++;
        logger.log(Level.INFO, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        return new ResponseEntity(requestCount, HttpStatus.OK);
    }

    @GetMapping("/request_time")
    public ResponseEntity getRequestTime(){
        var time = new Random().nextInt(1000);
        return new ResponseEntity(String.format("request time %d ms",time), HttpStatus.OK);
    }

}
