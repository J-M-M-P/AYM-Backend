package dat3.aym.controller;

import dat3.aym.dto.SizeDto;
import dat3.aym.entity.Size;
import dat3.aym.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {

    @Autowired
    SizeService sizeService;

    //Get all sizes
    @GetMapping("")
    public List<SizeDto> getAllSizes() {
        return sizeService.getAllSizes();
    }

    //Get size based on id
    @GetMapping("/{id}")
    public SizeDto getSizeById(@PathVariable int id) {
        return sizeService.getSizeById(id);
    }

    //Post size to database
    @PostMapping("")
    public Size addSize(@RequestBody Size size) {
        return sizeService.createSize(size);
    }

    //Update size in database
    @PutMapping("/{id}")
    public Size updateSize(@PathVariable int id, @RequestBody Size size) {
        return sizeService.updateSize(id, size);
    }

    //Delete size in database
    @DeleteMapping("/{id}")
    public String deleteSize(@PathVariable int id) {
        sizeService.deleteSize(id);
        return "Size with ID: " + id + " has been deleted";
    }

}
