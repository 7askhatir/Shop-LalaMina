package Ecommerce.LalaMina.entity;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

@Setter

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Panier {
    @Id
    private Long idPanier;
    private HashMap<Long, Integer> produits;
    private String utilisateur;
    private  String coupon;
    private double prixToutale;

}
