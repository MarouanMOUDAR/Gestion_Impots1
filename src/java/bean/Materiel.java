/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */
@Entity
public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private int statut;
  
    
    @ManyToOne
    private Model model;
    @ManyToOne
    private Marque marque;
    @ManyToOne
    private Marchet marchet;
    @ManyToOne
    private Personnel personnel;
    @OneToMany
    private List<HistoriqueMateriel> historiqueMateriels;

    public Materiel() {
    }

    public Materiel(Long id) {
        this.id = id;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Marchet getMarchet() {
        return marchet;
    }

    public void setMarchet(Marchet marchet) {
        this.marchet = marchet;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public List<HistoriqueMateriel> getHistoriqueMateriels() {
        return historiqueMateriels;
    }

    public void setHistoriqueMateriels(List<HistoriqueMateriel> historiqueMateriels) {
        this.historiqueMateriels = historiqueMateriels;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiel)) {
            return false;
        }
        Materiel other = (Materiel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Materiel[ id=" + id + " ]";
    }
    
}
