package Ecommerce.LalaMina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    private Long idCategorie;
    @NotNull
    @Indexed(unique = true)
    private String nameCategorie;
    @NotNull
    private  String descCategorie;



}
