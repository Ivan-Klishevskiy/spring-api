package by.tms.springapi.controller;


import by.tms.springapi.dto.PetUpdateInStoreDto;
import by.tms.springapi.entity.Pet;
import by.tms.springapi.exception.petException.PetAlreadyExistException;
import by.tms.springapi.exception.petException.PetNotExistException;
import by.tms.springapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Pet pet) {
        try {
            petService.savePet(pet);
            return ResponseEntity.ok("successful operation");
        } catch (PetAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Pet pet) {
        try {
            return ResponseEntity.ok(petService.updatePet(pet));
        } catch (PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<?> findByStatus(@Valid @RequestBody Pet pet) {
        try {
            return ResponseEntity.ok(petService.findByStatus(pet));
        } catch (PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{petId}")
    public ResponseEntity<?> findPetById(@PathVariable long petId) {
        try {
            return ResponseEntity.ok(petService.findById(petId));
        } catch (PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{petId}")
    public ResponseEntity<?> update(@PathVariable Long petId, @RequestBody PetUpdateInStoreDto petUpdateInStoreDto) {
        petUpdateInStoreDto.setId(petId);

        try {
            return ResponseEntity.ok(petService.updatePetInStore(petUpdateInStoreDto));
        } catch (PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<?> delete(@PathVariable Long petId) {
        try {
            petService.delete(petId);
            return ResponseEntity.ok("successful operation");
        } catch (PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
