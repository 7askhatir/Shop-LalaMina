package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.validation.Valid;
import java.util.List;

public interface ProduitRepository extends MongoRepository<Produit,Long> {
    Produit findByIdProduit(Long id);
    Produit findProduitByNameProduit(String nom);
    List<Produit> findAllByCategorie(Categorie categorie);

    void delete(Produit produit);
}
