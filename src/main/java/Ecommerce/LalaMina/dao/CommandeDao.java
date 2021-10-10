package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Commande;
import Ecommerce.LalaMina.enums.CommandeEnum;

import java.util.List;

public interface CommandeDao {
    List<Commande> getAllCommand();
    List<Commande> getAllCommandeByStatu(CommandeEnum commandeEnum);
    void deletCommande(Long id);
    Commande changeEtateCommande(Long id,CommandeEnum commandeEnum);

}
