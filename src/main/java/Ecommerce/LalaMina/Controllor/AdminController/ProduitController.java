package Ecommerce.LalaMina.Controllor.AdminController;

import Ecommerce.LalaMina.dao.CategorieDaoImp;
import Ecommerce.LalaMina.dao.ProduitDaoImp;
import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.entity.Produit;
import Ecommerce.LalaMina.repository.ProduitRepository;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("Admin/produit")
public class ProduitController {
    @Autowired
    ProduitDaoImp produitDaoImp;
    @Autowired
    CategorieDaoImp categorieDaoImp;

    /**
     * Add Product
     * @param produit
     * @return produit
     */

    @PostMapping("/ajouter")
    public ResponseEntity<ResponseObjet<Produit>> addProduct(@Valid @RequestBody Produit produit){
       Produit produit1= produitDaoImp.addProduit(produit);
        ResponseObjet<Produit> responseObject=new ResponseObjet<Produit>(true,"Produit ajouté avec succès",produit1);
        return new ResponseEntity<ResponseObjet<Produit>>(responseObject,HttpStatus.ACCEPTED);
    }
    /**
     * gettAll prdouit
     * @param
     * @return List of product
     */

    @GetMapping("/")
    public  ResponseEntity<ResponseObjet<List<Produit>>> getAllProduct(){
        List<Produit> produits=produitDaoImp.getAllProduit();
        ResponseObjet<List<Produit>> listResponseObjet=new ResponseObjet<List<Produit>>(true,"List des produit",produits);
        return new ResponseEntity<ResponseObjet<List<Produit>>>(listResponseObjet,HttpStatus.OK);
    }
    /**
     * gettAll prdouit by catehorie
     * @param
     * @return List of product
     */
    @GetMapping("/categorie/{id}")
    public ResponseEntity<ResponseObjet<List<Produit>>> getProductByCategorie(@Valid @PathVariable("id") Long id){
        Categorie categorie=categorieDaoImp.findCategorieById(id);
        List<Produit> produits=produitDaoImp.findProduitByCategorie(categorie);
        ResponseObjet<List<Produit>> listResponseObjet=new ResponseObjet<List<Produit>>(true,"List des produit par categorie",produits);
        return new ResponseEntity<ResponseObjet<List<Produit>>>(listResponseObjet,HttpStatus.OK);
    }

    /**
     * Delet Product by id
     * @param id
     * @return
     */

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<ResponseObjet<Void>> deletProdyctById(@Valid @PathVariable("id") Long id){
        produitDaoImp.deletProduit(id);
        ResponseObjet<Void> voidResponseObjet=new ResponseObjet<Void>(true,"le produit et supprimer ",null);
        return new ResponseEntity<ResponseObjet<Void>>(HttpStatus.OK);

    }

    /**
     * update Produit by id
     * @param id and produit
     * @return produit
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObjet<Produit>> updateProduit(@Valid @PathVariable("id") Long id,@RequestBody Produit produit){
       Produit produit1=produitDaoImp.updateProduit(produit,id);
       ResponseObjet<Produit> produitResponseObjet=new ResponseObjet<Produit>(true,"les produit et modifie",produit1);
       return  new ResponseEntity<ResponseObjet<Produit>>(produitResponseObjet,HttpStatus.ACCEPTED);
    }

}
