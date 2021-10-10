package Ecommerce.LalaMina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @Indexed(unique = true)@NotNull
    private Long idProduit;
    @Indexed(unique = true)@NotNull
    private String nameProduit;
    @NotNull
   private Double price;
    @NotNull
   private int quantity;
   private List<String> images;
   private Categorie categorie;
}
