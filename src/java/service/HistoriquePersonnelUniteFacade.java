/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.HistoriquePersonnelUnite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class HistoriquePersonnelUniteFacade extends AbstractFacade<HistoriquePersonnelUnite> {

    @PersistenceContext(unitName = "impotsG1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriquePersonnelUniteFacade() {
        super(HistoriquePersonnelUnite.class);
    }
    
}