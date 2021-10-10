package Ecommerce.LalaMina.entity;

import Ecommerce.LalaMina.enums.utilisateurEnum;
import lombok.*;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Utilisateur {


     @Id
     private String id;
     private String Usernom;
     private String prenom;
     private String email;
     private String password;
     private String phone;
     private utilisateurEnum active;
     private Boolean etat ;
     private String paysUser;
     private String villeUser;
     private int codePostalUser;
     private Date DateNaissanceUser;
     private List<Role> role;
}
