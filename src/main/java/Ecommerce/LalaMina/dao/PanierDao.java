package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Panier;
import Ecommerce.LalaMina.entity.Produit;

import java.util.List;

public interface PanierDao {
    Panier addPanie(Panier panier);
    Panier addProductToPanier(Long id ,Panier panier);



}
