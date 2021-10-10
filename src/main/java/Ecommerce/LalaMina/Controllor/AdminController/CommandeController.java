package Ecommerce.LalaMina.Controllor.AdminController;

import Ecommerce.LalaMina.dao.CommandeDao;
import Ecommerce.LalaMina.entity.Commande;
import Ecommerce.LalaMina.enums.CommandeEnum;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("Admin/Command")
public class CommandeController {
    @Autowired
    CommandeDao commandeDao;

    @GetMapping("/")
    public ResponseEntity<ResponseObjet<List<Commande>>> getAllCommande(){
        List<Commande> commandes=commandeDao.getAllCommand();
        ResponseObjet<List<Commande>> listResponseObjet=new ResponseObjet<List<Commande>>(true,"list des Commande",commandes);
        return new ResponseEntity<ResponseObjet<List<Commande>>>(listResponseObjet, HttpStatus.OK);
    }

    @GetMapping("/{etat}")
    public ResponseEntity<ResponseObjet<List<Commande>>> getAllCommandeByStatus(@Valid @PathVariable CommandeEnum commandeEnum){
        List<Commande> commandes=commandeDao.getAllCommandeByStatu(commandeEnum);
        ResponseObjet<List<Commande>> listResponseObjet=new ResponseObjet<List<Commande>>(true,"List Des Commande qui" +commandes,commandes);
        return new ResponseEntity<ResponseObjet<List<Commande>>>(listResponseObjet,HttpStatus.OK);
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<ResponseObjet<Void>> deletCommandeById(@Valid @PathVariable Long id){
        commandeDao.deletCommande(id);
        ResponseObjet<Void> responseObjet=new ResponseObjet<Void>(true,"commande supprimer",null);
        return new ResponseEntity<ResponseObjet<Void>>(responseObjet,HttpStatus.OK);
    }

    @PutMapping("/changeEtat/{id}/{etet}")
    public ResponseEntity<ResponseObjet<Commande>> changeEtateCommande(@PathVariable("id") Long id,@PathVariable("etet") CommandeEnum commandeEnum){
        Commande commande= commandeDao.changeEtateCommande(id,commandeEnum);
        ResponseObjet<Commande> commandeResponseObjet=new ResponseObjet<Commande>(true,"etat a ete changé",commande);
        return new ResponseEntity<ResponseObjet<Commande>>(commandeResponseObjet,HttpStatus.ACCEPTED);

    }


}
