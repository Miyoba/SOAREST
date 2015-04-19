package rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController {
    private Databasehandler dbhandler = new Databasehandler();
    private Article article;
    private AtomicLong counter = new AtomicLong();

    @RequestMapping("/hinzufuegen")
    public Article hinzufuegen(@RequestParam(value="title") String title,@RequestParam(value="body") String body) {
        dbhandler.InsertHandler(title, body);
        return new Article(counter.incrementAndGet(),
                            String.format(title),String.format(body));
    }
    @RequestMapping("/aendern")
    public Article aendern(@RequestParam(value="id") int id,@RequestParam(value="title") String title,@RequestParam(value="body") String body) {
        dbhandler.UpdateHandler(id, title, body);
        return new Article(id,
                String.format(title),String.format(body));
    }
    @RequestMapping("/loeschen")
    public Article loeschen(@RequestParam(value="id") int id) {
        dbhandler.DeleteHandler(id);
        return new Article(id,
                String.format("deleted"),String.format("deleted"));
    }
}