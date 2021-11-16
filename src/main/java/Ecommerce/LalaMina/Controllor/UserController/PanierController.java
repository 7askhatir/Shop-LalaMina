package Ecommerce.LalaMina.Controllor.UserController;

import Ecommerce.LalaMina.dao.PanierDao;
import Ecommerce.LalaMina.entity.Panier;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("User/Panier")
public class PanierController {

    @Autowired
    PanierDao panierDao;

    @PostMapping("/add")
    public  ResponseEntity<ResponseObjet<Panier>> addPanier(@RequestBody Panier panier){
        ResponseObjet<Panier> objet=new ResponseObjet<>(true,"Panier Add",panierDao.addPanie(panier));
        return new ResponseEntity<>(objet,HttpStatus.OK);
    }

    @PostMapping("/AddProduc/{id}")
    public ResponseEntity<ResponseObjet<Panier>> addProductToPanier(@RequestParam Long id){
        return null;
    }
}
