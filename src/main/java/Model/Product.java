package Model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private Long id;
    private String name;
    private Category category;
    private int price;
    private String sku;
    private LocalDate fechaRegistro;
}