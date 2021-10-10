package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Categorie;
import Ecommerce.LalaMina.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieDaoImp implements CategorieDao{
    @Autowired
    CategorieRepository categorieRepository;


    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.insert(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie, Long id) {
        Categorie categorie1=findCategorieById(id);
        categorie1.setNameCategorie(categorie.getNameCategorie());
        categorie1.setDescCategorie(categorie.getDescCategorie());
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
      return   categorieRepository.findAll();
    }

    @Override
    public Categorie findCategorieById(Long id) {
        return categorieRepository.findByIdCategorie(id);
    }

    @Override
    public void deletCategorieById(Long id) {
        Categorie categorie=findCategorieById(id);
        categorieRepository.delete(categorie);
    }

    @Override
    public Categorie findCategoriByName(String s) {
        return categorieRepository.findByNameCategorie(s);
    }


}
