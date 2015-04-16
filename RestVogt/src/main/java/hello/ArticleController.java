package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hinzufuegen")
    public Article hinzufuegen(@RequestParam(value="title") String title,@RequestParam(value="body") String body) {
        return new Article(counter.incrementAndGet(),
                            String.format(title),String.format(body));
    }
    @RequestMapping("/aendern")
    public Article aendern(@RequestParam(value="id") int id,@RequestParam(value="title") String title,@RequestParam(value="body") String body) {
        return new Article(id,
                String.format(title),String.format(body));
    }
    @RequestMapping("/loeschen")
    public Article loeschen(@RequestParam(value="id") int id) {
        return new Article(id,
                String.format("deleted"),String.format("deleted"));
    }
}