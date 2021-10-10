package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategorieRepository extends MongoRepository<Categorie,Long> {
    Categorie findByIdCategorie(long l);
    Categorie findByNameCategorie(String s);

}
