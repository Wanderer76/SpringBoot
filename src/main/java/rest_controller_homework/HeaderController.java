package rest_controller_homework;

import com.fasterxml.jackson.core.JsonEncoding;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeaderController {

    @GetMapping("/headers")
    ResponseEntity<List<String>> getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        var result = new ArrayList<String>(headers.size());
        headers.forEach((key, val) -> {
            result.add(String.format("Header '%s' = '%s'", key,
                    String.join("|", val)));
        });
        return new ResponseEntity<List<String>>(result, HttpStatus.OK);
    }

    @PostMapping("/insert_id")
    ResponseEntity<Entity> setIdToBody(@RequestBody Entity info) {
        info.getInfo().setId();
        return new ResponseEntity<>(info, HttpStatus.OK);

    }
}
