package dat3.aym.controller;

import dat3.aym.dto.NewsDto;
import dat3.aym.entity.News;
import dat3.aym.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    //Get all news
    @GetMapping("")
    public List<NewsDto> getAllNews() {
        return newsService.getAllNews();
    }

    //Get news based on id
    @GetMapping("/{id}")
    public NewsDto getNewsById(@PathVariable int id) {
        return newsService.getNewsById(id);
    }

    //Post news to database
    @PostMapping("")
    public News addNews(@RequestBody News news) {
        return newsService.createNews(news);
    }

    //Update news in database
    @PutMapping("/{id}")
    public News updateNews(@PathVariable int id, @RequestBody News news) {
        return newsService.updateNews(id, news);
    }

    //Delete news in database
    @DeleteMapping("/{id}")
    public String deleteNews(@PathVariable int id) {
        newsService.deleteNews(id);
        return "News with ID: " + id + " has been deleted";
    }

}
