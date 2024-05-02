package dat3.aym.service;

import dat3.aym.dto.ColorDto;
import dat3.aym.entity.Color;
import dat3.aym.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    ColorRepository colorRepository;

    //Get all colors
    public List<ColorDto> getAllColors() {
        List<Color> colorList = colorRepository.findAll();
        List<ColorDto> colorDtoList = new ArrayList<>();

        for (Color color : colorList) {
            colorDtoList.add(new ColorDto(color));
        }

        return colorDtoList;
    }

    //Get color by id
    public ColorDto getColorById(int id) {
        Color color = colorRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "color not found"));
        return new ColorDto(color);
    }

    //Create color
    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

}
