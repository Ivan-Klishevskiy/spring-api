package by.tms.springapi.repository;

import by.tms.springapi.dto.PetStatusDto;
import by.tms.springapi.entity.Pet;
import by.tms.springapi.entity.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PetRepository extends JpaRepository<Pet,Long> {

    List<Pet> findAllByStatus(PetStatus status);
}
