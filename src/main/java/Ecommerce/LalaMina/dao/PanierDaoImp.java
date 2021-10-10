package Ecommerce.LalaMina.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecommerce.LalaMina.entity.Panier;
import Ecommerce.LalaMina.repository.PanierRepository;

@Service
public class PanierDaoImp implements  PanierDao{
    @Autowired
    PanierRepository panierRepository;
    @Override
    public Panier addPanie(Panier panier) {
        return panierRepository.save(panier);
    }
    
}
