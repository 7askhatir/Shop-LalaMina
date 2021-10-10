package Ecommerce.LalaMina.entity;

import Ecommerce.LalaMina.enums.CommandeEnum;
import lombok.*;

import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    private Long IdCommande;
    private Data dateCommande;
    private CommandeEnum etat;
    private Panier panier;
    private double priceToutale;

}
