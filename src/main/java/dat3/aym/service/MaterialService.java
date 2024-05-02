package dat3.aym.service;

import dat3.aym.dto.ColorDto;
import dat3.aym.dto.MaterialDto;
import dat3.aym.entity.Color;
import dat3.aym.entity.Material;
import dat3.aym.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    //Get all materials
    public List<MaterialDto> getAllMaterials() {
        List<Material> materialList = materialRepository.findAll();
        List<MaterialDto> materialDtoList = new ArrayList<>();

        for (Material material : materialList) {
            materialDtoList.add(new MaterialDto(material));
        }
        return materialDtoList;
    }


    //Get material by id
    public MaterialDto getMaterialById(int id) {
        Material material = materialRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "material not found"));
        return new MaterialDto(material);
    }

    //Create new material
    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    //Delete material
    public void deleteMaterial(int materialId) {
        materialRepository.deleteById(materialId);
    }

    //Update material
    public Material updateMaterial(int materialId, Material updatedMaterial) {
        // Check if material with that ID exists in database
        Optional<Material> existingMaterialOptional = materialRepository.findById(materialId);

        if (existingMaterialOptional.isPresent()) {
            // If material exists, update the rest of the properties
            Material existingMaterial = existingMaterialOptional.get();
            existingMaterial.setName(updatedMaterial.getName());

            // Save updated material in database
            return materialRepository.save(existingMaterial);
        } else {
            // If material does not exist in database, throw error
            throw new RuntimeException("Color with ID: " + materialId + " not found");
        }
    }
}
