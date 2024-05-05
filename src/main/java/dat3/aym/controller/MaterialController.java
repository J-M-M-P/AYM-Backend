package dat3.aym.controller;

import dat3.aym.dto.MaterialDto;
import dat3.aym.entity.Material;
import dat3.aym.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //Get all colors
    @GetMapping("")
    public List<MaterialDto> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    //Get material based on id
    @GetMapping("/{id}")
    public MaterialDto getMaterialById(@PathVariable int id) {
        return materialService.getMaterialById(id);
    }

    //Post material to database
    @PostMapping("")
    public Material addMaterial(@RequestBody Material material) {
        return materialService.createMaterial(material);
    }

    //Update color in database
    @PutMapping("/{id}")
    public Material updateMaterial(@PathVariable int id, @RequestBody Material material) {
        return materialService.updateMaterial(id, material);
    }

    //Delete color in database
    @DeleteMapping("/{id}")
    public String deleteMaterial(@PathVariable int id) {
        materialService.deleteMaterial(id);
        return "Material with ID: " + id + " has been deleted";
    }

}
