package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

		// My bad I broke this in the last merge, I didn't read the tests
		// I am putting it back. 
    private static final String template = "Hello there, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/")
    public String defaultEndpoint(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }
}
