package dat3.aym.dto;

import dat3.aym.entity.Material;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaterialDto {
    private int id;
    private String name;

    public MaterialDto(Material m){
        this.id = m.getId();
        this.name= m.getName();
    }
}
