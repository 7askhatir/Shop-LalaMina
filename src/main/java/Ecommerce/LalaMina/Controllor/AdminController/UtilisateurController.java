package Ecommerce.LalaMina.Controllor.AdminController;

import Ecommerce.LalaMina.dao.UtilisateurDao;
import Ecommerce.LalaMina.entity.Utilisateur;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("Admin/utilisateur")
public class UtilisateurController {
    @Autowired
    UtilisateurDao utilisateurDao;

    @GetMapping("/")
    public ResponseEntity<ResponseObjet<List<Utilisateur>>> getAllUser(){
        List<Utilisateur> utilisateurs=utilisateurDao.getAllUser();
        ResponseObjet<List<Utilisateur>> listResponseObjet=new ResponseObjet<List<Utilisateur>>(true,"list des utilisateur",utilisateurs);
        return new ResponseEntity<ResponseObjet<List<Utilisateur>>>(listResponseObjet, HttpStatus.OK);
    }


    @GetMapping("/pending")
    public ResponseEntity<ResponseObjet<List<Utilisateur>>> getUserPending(){
        List<Utilisateur> utilisateurs=utilisateurDao.getAllUserPending();
        ResponseObjet<List<Utilisateur>> listResponseObjet=new ResponseObjet<List<Utilisateur>>(true,"list des utilisateur en attendant",utilisateurs);
        return new ResponseEntity<ResponseObjet<List<Utilisateur>>>(listResponseObjet,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObjet<Utilisateur>> updateUser(@Valid @PathVariable String id, @RequestBody Utilisateur utilisateur){
        Utilisateur utilisateur1=utilisateurDao.updateUserById(utilisateur, id);
        ResponseObjet<Utilisateur> utilisateurResponseObjet=new ResponseObjet<Utilisateur>(true,"utilisateur et modifié",utilisateur1);
        return new ResponseEntity<ResponseObjet<Utilisateur>>(utilisateurResponseObjet,HttpStatus.ACCEPTED);
    }

    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<ResponseObjet<Utilisateur>> changeStatus(@Valid @PathVariable String id){
        Utilisateur utilisateur=utilisateurDao.changeEtat(id);
        ResponseObjet<Utilisateur> utilisateurResponseObjet=new ResponseObjet<Utilisateur>(true,"statue d'utilisateur et change",utilisateur);
        return new ResponseEntity<ResponseObjet<Utilisateur>>(utilisateurResponseObjet,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity<ResponseObjet<Void>> deletUser(@Valid @PathVariable String id){
        utilisateurDao.deletUser(id);
        ResponseObjet<Void> voidResponseObjet=new ResponseObjet<Void>(true,"utilisateur a été supprimer ",null);
        return new ResponseEntity<ResponseObjet<Void>>(voidResponseObjet,HttpStatus.OK);
    }


}
