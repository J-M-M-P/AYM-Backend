package dat3.aym.service;

import dat3.aym.dto.NewsDto;
import dat3.aym.entity.News;
import dat3.aym.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    //Get all news
    public List<NewsDto> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        List<NewsDto> newsDtoList = new ArrayList<>();

        for (News news : newsList) {
            newsDtoList.add(new NewsDto(news));
        }

        return newsDtoList;
    }

    //Get news by id
    public NewsDto getNewsById(int id) {
        News news = newsRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found"));
        return new NewsDto(news);
    }

    //Create news
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    //Delete news
    public void deleteNews(int newsId) {
        newsRepository.deleteById(newsId);
    }

    //Update news
    public News updateNews(int newsId, News updatedNews) {
        // Check if news with that ID exists in database
        Optional<News> existingNewsOptional = newsRepository.findById(newsId);

        if (existingNewsOptional.isPresent()) {
            // If news exists, update the rest of the properties
            News existingNews = existingNewsOptional.get();
            existingNews.setCreated(updatedNews.getCreated());
            existingNews.setHeadline(updatedNews.getHeadline());
            existingNews.setContent(updatedNews.getContent());
            existingNews.setImage(updatedNews.getImage());

            // Save updated news in database
            return newsRepository.save(existingNews);
        } else {
            // If news does not exist in database, throw error
            throw new RuntimeException("News with ID: " + newsId + " not found");
        }
    }

}
