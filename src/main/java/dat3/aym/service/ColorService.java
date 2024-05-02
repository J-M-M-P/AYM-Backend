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
import java.util.Optional;

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

    //Delete color
    public void deleteColor(int colorId) {
        colorRepository.deleteById(colorId);
    }

    //Update color
    public Color updateColor(int colorId, Color updatedColor) {
        // Check if color with that ID exists in database
        Optional<Color> existingColorOptional = colorRepository.findById(colorId);

        if (existingColorOptional.isPresent()) {
            // If color exists, update the rest of the properties
            Color existingColor = existingColorOptional.get();
            existingColor.setColorName(updatedColor.getColorName());
            //existingEquipment.setStatus(updatedEquipment.isStatus());
            //existingEquipment.setTotalUnits(updatedEquipment.getTotalUnits());
            //existingEquipment.setDefectiveUnits(updatedEquipment.getDefectiveUnits());
            //existingEquipment.setActivity(updatedEquipment.getActivity());

            // Save updated color in database
            return colorRepository.save(existingColor);
        } else {
            // If color does not exist in database, throw error
            throw new RuntimeException("Equipment with ID: " + colorId + " not found");
        }
    }

}
