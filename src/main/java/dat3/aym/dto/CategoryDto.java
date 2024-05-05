package dat3.aym.dto;

import dat3.aym.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private int id;
    private String name;

    public CategoryDto(Category c){
        this.id = c.getId();
        this.name = c.getName();
    }

}
