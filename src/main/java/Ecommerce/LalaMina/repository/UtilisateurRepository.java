package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Produit;
import Ecommerce.LalaMina.entity.Utilisateur;
import Ecommerce.LalaMina.enums.utilisateurEnum;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UtilisateurRepository extends MongoRepository<Utilisateur,Long> {
    List<Utilisateur> findAllByActive(utilisateurEnum s);
    Utilisateur findUtilisateurById(String aLong);
    Utilisateur findUtilisateurByEmailAndPhone(String email,String phone);
    @Query("{$or :[{email: ?0},{phone: ?1}]}")
    Utilisateur findUtilisateurByEmailOrPhone(String email,String phone);

}
