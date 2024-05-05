package dat3.aym.dto;

import dat3.aym.entity.Color;
import dat3.aym.entity.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SizeDto {
    private int id;
    private String sizeName;

    public SizeDto(Size s){
        this.id = s.getId();
        this.sizeName = s.getSizeName();
    }

}
