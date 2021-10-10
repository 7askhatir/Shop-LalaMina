package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Commande;
import Ecommerce.LalaMina.enums.CommandeEnum;
import Ecommerce.LalaMina.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeDaoImp implements CommandeDao{
    @Autowired
    CommandeRepository commandeRepository;
    @Override
    public List<Commande> getAllCommand() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> getAllCommandeByStatu(CommandeEnum commandeEnum) {
        return commandeRepository.findAllByEtat(commandeEnum);
    }

    @Override
    public void deletCommande(Long id) {
        Commande commande=commandeRepository.findByIdCommande(id);
        if(commande!=null)commandeRepository.delete(commande);
    }

    @Override
    public Commande changeEtateCommande(Long id,CommandeEnum commandeEnum) {
        Commande commande= commandeRepository.findByIdCommande(id);
        commande.setEtat(commandeEnum);
        return commandeRepository.save(commande);
    }

}
