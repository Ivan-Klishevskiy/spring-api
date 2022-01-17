package by.tms.springapi.dto;

import by.tms.springapi.entity.PetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetStatusDto {
    private PetStatus status;
}
