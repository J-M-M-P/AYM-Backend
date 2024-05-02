package dat3.aym.controller;

import dat3.aym.dto.ColorDto;
import dat3.aym.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping("")
    public List<ColorDto> getAllColors() {
        return colorService.getAllColors();
    }
}
