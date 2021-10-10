package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Utilisateur;
import Ecommerce.LalaMina.enums.utilisateurEnum;
import Ecommerce.LalaMina.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class UtilisateurDaoImp implements UtilisateurDao{
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public List<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Utilisateur> getAllUserPending() {
        return utilisateurRepository.findAllByActive(utilisateurEnum.PENDING);
    }

    @Override
    public Utilisateur updateUserById(Utilisateur utilisateur, String id) {
        Utilisateur utilisateur1=utilisateurRepository.findUtilisateurById(id);
        if(utilisateur!=null){
            utilisateur1.setActive(utilisateur.getActive());
            utilisateur1.setEtat(utilisateur.getEtat());
            utilisateur1.setRole(utilisateur.getRole());
        }
        return utilisateurRepository.save(utilisateur1);
    }


    @Override
    public void deletUser(String id) {
        Utilisateur utilisateur1=utilisateurRepository.findUtilisateurById(id);
        if(utilisateur1!=null)utilisateurRepository.delete(utilisateur1);
    }

    @Override
    public Utilisateur changeEtat(String id){
        Utilisateur utilisateur=utilisateurRepository.findUtilisateurById(id);
        utilisateur.setEtat(!utilisateur.getEtat());
      return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur addUser(Utilisateur utilisateur) {    
       String id=createRandomId();
        Utilisateur utilisateur1=utilisateurRepository.findUtilisateurById(id); 
        while(utilisateur1!=null){
            id=createRandomId();
        }
        Utilisateur utilisateur2=utilisateurRepository.findUtilisateurByEmailAndPhone(utilisateur.getEmail(), utilisateur.getPhone());
        utilisateur.setId(id);
        if(utilisateur2==null)return utilisateurRepository.save(utilisateur);
        else return null;
        
    }

    @Override
    public String createRandomId(){
        String id = "";
    String charactere ="ABCDEFJHIGKLMNUPQRSTUVWXYZabcdefghijklmnupqrstuvwxyz1234567890";
    int length = 32;
    Random random=new Random();
    char[] text =new char[length];
        for(int i=0;i<length;i++){
            text[i] = charactere.charAt(random.nextInt(charactere.length()));
        }
        for(int i=0;i<text.length;i++){
            id += text[i];
        }
        return id;
    }

    @Override
    public Utilisateur findUserByEmailOrPhone(String s) {
        return utilisateurRepository.findUtilisateurByEmailOrPhone(s,s);
    }
    
}
