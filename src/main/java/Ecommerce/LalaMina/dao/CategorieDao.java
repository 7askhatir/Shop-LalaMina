package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Categorie;

import java.util.List;

public interface CategorieDao {
    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie,Long id);
    List<Categorie> getAllCategorie();
    Categorie findCategorieById(Long id);
    void deletCategorieById(Long id);
    Categorie findCategoriByName(String s);
}
