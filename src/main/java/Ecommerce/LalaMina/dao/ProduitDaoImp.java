package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Produit;
import Ecommerce.LalaMina.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitDaoImp implements ProduitDao{
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit produit) {
       return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findProduitById(Long id) {
        return produitRepository.findByIdProduit(id);
    }

    @Override
    public Produit findProduitByNom(String nom) {
        return produitRepository.findProduitByNameProduit(nom);
    }

    @Override
    public List<Produit> findProduitByCategorie(Categorie Cate) {
        return produitRepository.findAllByCategorie(Cate);
    }

    @Override
    public Produit updateProduit(Produit produit ,Long id){
        Produit produit1=produitRepository.findByIdProduit(id);
        produit1.setNameProduit(produit.getNameProduit());
        produit1.setCategorie(produit.getCategorie());
        produit1.setPrice(produit.getPrice());
        produit1.setImages(produit.getImages());
        produit1.setQuantity(produit.getQuantity());
        produitRepository.save(produit1);
        return produit1;

    }

    @Override
    public void deletProduit(Long id) {
     Produit produit=produitRepository.findByIdProduit(id);
     System.out.println(produit.toString());
     produitRepository.delete(produit);
    }
}
