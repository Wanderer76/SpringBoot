package aspects_homework;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/make_response")
    public ResponseEntity<String> createResponse() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
