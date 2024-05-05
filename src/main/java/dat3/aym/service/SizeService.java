package dat3.aym.service;

import dat3.aym.dto.ColorDto;
import dat3.aym.dto.MaterialDto;
import dat3.aym.dto.SizeDto;
import dat3.aym.entity.Color;
import dat3.aym.entity.Material;
import dat3.aym.entity.Size;
import dat3.aym.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Autowired
    SizeRepository sizeRepository;


    //Get all sizes
    public List<SizeDto> getAllSizes() {
        List<Size> sizeList = sizeRepository.findAll();
        List<SizeDto> sizeDtoList = new ArrayList<>();

        for (Size size : sizeList) {
            sizeDtoList.add(new SizeDto(size));
        }
        return sizeDtoList;
    }

    //Get size by id
    public SizeDto getSizeById(int id) {
        Size size = sizeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "size not found"));
        return new SizeDto(size);
    }

    //Create color
    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }

    //Delete size
    public void deleteSize(int sizeId) {
        sizeRepository.deleteById(sizeId);
    }

    //Update size
    public Size updateSize(int sizeId, Size updatedSize) {
        // Check if size with that ID exists in database
        Optional<Size> existingSizeOptional = sizeRepository.findById(sizeId);

        if (existingSizeOptional.isPresent()) {
            // If size exists, update the rest of the properties
            Size existingSize = existingSizeOptional.get();
            existingSize.setSizeName(updatedSize.getSizeName());

            // Save updated size in database
            return sizeRepository.save(existingSize);
        } else {
            // If size does not exist in database, throw error
            throw new RuntimeException("Size with ID: " + sizeId + " not found");
        }
    }
}
