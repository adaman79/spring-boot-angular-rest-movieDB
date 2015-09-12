package movie.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fema on 12.09.15.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
