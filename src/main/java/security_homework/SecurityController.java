package security_homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityController {

    @GetMapping("public/")
    public String checkConnection(Principal principal) {
        return "Connection to any user. Connectoed: " + principal.getName();
    }

    @GetMapping("/admin/api")
    public String adminConnect(Principal principal) {
        return "Admin connected: " + principal.getName();
    }

    @GetMapping("/support/api")
    public String supportConnect(Principal principal) {
        return "Support connected: " + principal.getName();
    }

}
