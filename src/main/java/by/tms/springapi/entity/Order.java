package by.tms.springapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHOP")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @NotNull
    private long petId;

    @NotBlank
    @NotEmpty
    @NotNull
    private int quantity;

    @NotBlank
    @NotEmpty
    @NotNull
    private String shipDate;

    private OrderStatus status;
}
