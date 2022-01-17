package by.tms.springapi.service;

import by.tms.springapi.dto.PetStatusDto;
import by.tms.springapi.dto.PetUpdateInStoreDto;
import by.tms.springapi.entity.Pet;
import by.tms.springapi.entity.PetStatus;
import by.tms.springapi.exception.petException.PetAlreadyExistException;
import by.tms.springapi.exception.petException.PetNotExistException;
import by.tms.springapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void savePet(Pet pet) throws PetAlreadyExistException {
        if(petRepository.existsById(pet.getId())){
            throw new PetAlreadyExistException("Pet already exist");
        }else {
            petRepository.save(pet);
        }
    }

    public Pet updatePet(Pet pet) throws PetNotExistException {
        if(petRepository.existsById(pet.getId())){
            return petRepository.save(pet);
        }else{
            throw new PetNotExistException("Pet not exist");
        }
    }

    public List<Pet> findByStatus(Pet pet) throws PetNotExistException {
        if(petRepository.findAllByStatus(pet.getStatus()).isEmpty()){
            throw new PetNotExistException("Pet not exist");
        }else {
            return petRepository.findAllByStatus(pet.getStatus());
        }
    }

    public Pet findById(Long id) throws PetNotExistException {
        if(petRepository.findById(id).isPresent()){
            return petRepository.findById(id).get();
        }else{
            throw new PetNotExistException("Pet not exist");
        }
    }

    public Pet updatePetInStore(PetUpdateInStoreDto petUpdateInStoreDto) throws PetNotExistException {
        if(petRepository.findById(petUpdateInStoreDto.getId()).isPresent()){
            Pet pet = petRepository.findById(petUpdateInStoreDto.getId()).get();
            pet.setName(petUpdateInStoreDto.getName());
            pet.setStatus(petUpdateInStoreDto.getStatus());
            return petRepository.save(pet);
        }else{
            throw new PetNotExistException("Pet not exist");
        }
    }

    public void delete(Long id) throws PetNotExistException {
        if(petRepository.existsById(id)){
            petRepository.deleteById(id);
        }else{
            throw new PetNotExistException("Pet not exist");
        }
    }
}
