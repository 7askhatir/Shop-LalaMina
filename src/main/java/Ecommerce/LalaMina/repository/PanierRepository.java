package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Panier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PanierRepository extends MongoRepository<Panier,Long> {
    
}
