package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Commande;
import Ecommerce.LalaMina.enums.CommandeEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommandeRepository extends MongoRepository<Commande,Long> {
   List<Commande> findAllByEtat(CommandeEnum commandeEnum);
   Commande findByIdCommande(Long aLong);
}
