package Ecommerce.LalaMina.Controllor.UserController;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Ecommerce.LalaMina.dao.UtilisateurDao;
import Ecommerce.LalaMina.entity.Utilisateur;
import Ecommerce.LalaMina.request.LoginForm;
import Ecommerce.LalaMina.response.ResponseObjet;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UtilisateurDao utilisateurDao;

    @PostMapping("register")
    public ResponseEntity<ResponseObjet<Utilisateur>> register(@RequestBody Utilisateur utilisateur){
        Utilisateur utilisateur2=utilisateurDao.addUser(utilisateur);
        ResponseObjet<Utilisateur> objet = new ResponseObjet<Utilisateur>(false,"this compte is aleredy exist",null);;
        if(utilisateur2!=null) objet = new ResponseObjet<Utilisateur>(true,"register succefel",utilisateur2);
          return new ResponseEntity<>(objet,HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    public ResponseEntity<ResponseObjet<Utilisateur>> login(@RequestBody LoginForm l ){
        Utilisateur utilisateur= utilisateurDao.findUserByEmailOrPhone(l.getEmailOrPhone());
        ResponseObjet<Utilisateur>objet;
        if(utilisateur==null)objet=new ResponseObjet<>(false,"this phone or email n'exist pas",null);
        else if(!utilisateur.getPassword().equals(l.getPassword()))objet=new ResponseObjet<>(false,"password incorrect",null);
        else objet =new ResponseObjet<>(true,"Login succecfel",utilisateur);
    return new ResponseEntity<>(objet,HttpStatus.OK);
    }

    





    
}
