package dat3.aym.dto;

import dat3.aym.entity.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColorDto {
    private int id;
    private String colorName;

    public ColorDto(Color c){
        this.id = c.getId();
        this.colorName = c.getColorName();
    }

}
