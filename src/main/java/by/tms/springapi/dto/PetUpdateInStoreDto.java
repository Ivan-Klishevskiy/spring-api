package by.tms.springapi.dto;

import by.tms.springapi.entity.PetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetUpdateInStoreDto {

    private long id;

    private String name;

    private PetStatus status;
}
