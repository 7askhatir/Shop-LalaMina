package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Utilisateur;
import Ecommerce.LalaMina.enums.utilisateurEnum;

import java.util.List;

public interface UtilisateurDao {
    List<Utilisateur> getAllUser();
    List<Utilisateur> getAllUserPending();
    Utilisateur updateUserById( Utilisateur utilisateur, String id);
    void deletUser(String id);
    Utilisateur changeEtat(String id);
    Utilisateur addUser(Utilisateur utilisateur);
    public String createRandomId();
    Utilisateur findUserByEmailOrPhone(String s);
}
