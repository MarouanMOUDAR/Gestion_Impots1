/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Materiel;
import bean.Personnel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class PersonnelFacade extends AbstractFacade<Personnel> {

    @PersistenceContext(unitName = "impotsG1PU")
    private EntityManager em;

    public List<Materiel> findMatosNnAffecte(){
        return em.createQuery("SELECT m FROM Materiel m WHERE m.statut=0").getResultList();
    }
    
    public List<Personnel> filterByNom(String nom){
        return em.createQuery("SELECT p FROM Personnel p WHERE personnel.nom='"+nom+"'").getResultList();
    }
    public List<Personnel> filterByPrenom(String prenom){
        return em.createQuery("SELECT p FROM Personnel p WHERE personnel.prenom='"+prenom+"'").getResultList();
    }
    public List<Personnel> filterById(Long id){
        return em.createQuery("SELECT p FROM Personnel p WHERE personnel.id='"+id.toString()+"'").getResultList();
    }
    public List<Materiel> findMateriel(Personnel personnel){
        
        List<Materiel> m= em.createQuery("SELECT m FROM Materiel m WHERE m.personnel.id='"+personnel.getId().toString()+"'").getResultList();
        
        return m;
        
        
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnelFacade() {
        super(Personnel.class);
    }
    
}
