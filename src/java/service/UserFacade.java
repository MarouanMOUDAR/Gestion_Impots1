/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "impotsG1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public int seConnecter(String password,String login){
       User utilisateur = (User) em.createQuery("select u from User u where u.login='"+login+"'").getSingleResult();
       if(utilisateur==null){
          return -1;
       }else if(!utilisateur.getPassword().equals(password)){
           return -2;
       }else if(!utilisateur.getLogin().equals(login)){
           return -3;
       }
       else if(utilisateur.getType()==3){
           return 3;
       }
       else if(utilisateur.getType()==2){
           return 2;
       }
       else {
           return 1;
       }
   }
    
    public UserFacade() {
        super(User.class);
    }
    
}
