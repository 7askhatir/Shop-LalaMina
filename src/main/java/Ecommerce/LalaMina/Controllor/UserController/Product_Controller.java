package Ecommerce.LalaMina.Controllor.UserController;

import Ecommerce.LalaMina.dao.CategorieDao;
import Ecommerce.LalaMina.dao.ProduitDao;
import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Panier;
import Ecommerce.LalaMina.entity.Produit;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("User/produit")
public class Product_Controller {
    @Autowired
    ProduitDao produitDao;
    @Autowired
    CategorieDao categorieDao;

    @GetMapping("/")
    public ResponseEntity<ResponseObjet<List<Produit>>> getAllProducts(){
        List<Produit> produits=produitDao.getAllProduit();
        ResponseObjet<List<Produit>> listResponseObjet=new ResponseObjet<List<Produit>>(true,"List des Produit ",produits);
        return new ResponseEntity<ResponseObjet<List<Produit>>>(listResponseObjet, HttpStatus.OK);

    }
    @GetMapping("/{categorie}")
    public ResponseEntity<ResponseObjet<List<Produit>>> getAllProductByCategorie(@Valid @PathVariable String categorie){
        Categorie categorie1=categorieDao.findCategoriByName(categorie);
        List<Produit> produits=produitDao.findProduitByCategorie(categorie1);
        ResponseObjet<List<Produit>> listResponseObjet=new ResponseObjet<List<Produit>>(true,"List de produit par Categorie "+categorie,produits);
        return new ResponseEntity<ResponseObjet<List<Produit>>>(listResponseObjet,HttpStatus.OK);
    }


}
