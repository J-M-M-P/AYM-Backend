package dat3.aym.service;

import dat3.aym.dto.ColorDto;
import dat3.aym.entity.Color;
import dat3.aym.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    ColorRepository colorRepository;

    //Get all equipment
    public List<ColorDto> getAllColors() {
        List<Color> colorList = colorRepository.findAll();
        List<ColorDto> colorDtoList = new ArrayList<>();

        for (Color color : colorList) {
            colorDtoList.add(new ColorDto(color));
        }

        return colorDtoList;
    }
}
