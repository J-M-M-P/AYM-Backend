package dat3.aym.dto;

import dat3.aym.entity.News;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class NewsDto {
    private int id;
    private LocalDateTime created;
    private String headline;
    private String content;
    private String image;

    public NewsDto(News n) {
        this.id = n.getId();
        this.created = n.getCreated();
        this.headline = n.getHeadline();
        this.content = n.getContent();
        this.image = n.getImage();
    }
}
