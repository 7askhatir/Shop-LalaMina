package Ecommerce.LalaMina.dao;


import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Produit;

import java.util.List;

public interface ProduitDao {
    Produit addProduit(Produit produit);
    List<Produit> getAllProduit();
    Produit findProduitById(Long id);
    Produit findProduitByNom(String nom);
    List<Produit> findProduitByCategorie(Categorie idCate);
    Produit updateProduit(Produit produit,Long aLong);
    void deletProduit(Long id);
}
