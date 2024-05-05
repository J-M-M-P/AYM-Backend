package dat3.aym.controller;

import dat3.aym.dto.ColorDto;
import dat3.aym.entity.Color;
import dat3.aym.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    @Autowired
    ColorService colorService;

    //Get all colors
    @GetMapping("")
    public List<ColorDto> getAllColors() {
        return colorService.getAllColors();
    }

    //Get color based on id
    @GetMapping("/{id}")
    public ColorDto getColorById(@PathVariable int id) {
        return colorService.getColorById(id);
    }

    //Post color to database
    @PostMapping("")
    public Color addColor(@RequestBody Color color) {
        return colorService.createColor(color);
    }

    //Update color in database
    @PutMapping("/{id}")
    public Color updateColor(@PathVariable int id, @RequestBody Color color) {
        return colorService.updateColor(id, color);
    }

    //Delete color in database
    @DeleteMapping("/{id}")
    public String deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
        return "Color with ID: " + id + " has been deleted";
    }

}
