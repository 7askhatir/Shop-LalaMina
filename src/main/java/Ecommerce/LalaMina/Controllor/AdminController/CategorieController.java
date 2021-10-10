package Ecommerce.LalaMina.Controllor.AdminController;

import Ecommerce.LalaMina.dao.CategorieDao;
import Ecommerce.LalaMina.dao.CategorieDaoImp;
import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("Admin/categorie")
public class CategorieController {
    @Autowired
    CategorieDao categorieDao;

    /**
     * Add Categorie
     * @param categorie Form
     * @return Categorie
     */

    @PostMapping("/ajouter")
    public ResponseEntity<ResponseObjet<Categorie>> addCategorie(@RequestBody Categorie categorie){
        Categorie categorie1=categorieDao.addCategorie(categorie);
        ResponseObjet<Categorie> categorieResponseObjet=new ResponseObjet<Categorie>(true,"Categori ajouté avec succès",categorie1);
        return new ResponseEntity<ResponseObjet<Categorie>>(categorieResponseObjet, HttpStatus.ACCEPTED);
    }
    /**
     * gettAll Categorie
     * @param
     * @return List of product
     */
    @GetMapping("/")
    public ResponseEntity<ResponseObjet<List<Categorie>>> getAllCategorie(){
        List<Categorie> categories=categorieDao.getAllCategorie();
        ResponseObjet<List<Categorie>> listResponseObjet=new ResponseObjet<List<Categorie>>(true,"List des Categories",categories);
        return new ResponseEntity<ResponseObjet<List<Categorie>>>(listResponseObjet,HttpStatus.OK);
    }
    /**
     * Delet Categorie by id
     * @param id
     * @return
     */

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<ResponseObjet<Void>> deletCategorieById(@Valid @PathVariable Long id){
        categorieDao.deletCategorieById(id);
        ResponseObjet<Void> voidResponseObjet=new ResponseObjet<Void>(true,"le categorie et supprimer",null);
        return new ResponseEntity<ResponseObjet<Void>>(voidResponseObjet,HttpStatus.OK);
    }

    /**
     * update Categorie by id
     * @param id and categorie
     * @return produit
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObjet<Categorie>> updateCategorie(@Valid @PathVariable Long id,@RequestBody Categorie categorie){
        Categorie categorie2=categorieDao.updateCategorie(categorie,id);
        ResponseObjet<Categorie> categorieResponseObjet=new ResponseObjet<Categorie>(true,"Categorie et modifié",categorie2);
        return  new ResponseEntity<ResponseObjet<Categorie>>(categorieResponseObjet,HttpStatus.OK);
    }

}
