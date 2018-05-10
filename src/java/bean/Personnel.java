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
import javax.persistence.OneToOne;

/**
 *
 * @author HP
 */
@Entity
public class Personnel implements Serializable {

    @OneToMany(mappedBy = "personnel")
    private List<HistoriquePersonnelUnite> historiquePersonnelUnites;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String mail;

    @ManyToOne
    private UniteDeGestion uniteDeGestion;

    @OneToMany(mappedBy = "personnel")
    private List<Materiel> materiels;

    @OneToMany(mappedBy = "personnel")
    private List<HistoriquePersonnelMateriel> historiquePersonnels;
    @ManyToOne
    @OneToOne(mappedBy = "personnel")
    private User user;

    public Personnel() {
    }

    public Personnel(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<HistoriquePersonnelUnite> getHistoriquePersonnelUnites() {
        return historiquePersonnelUnites;
    }

    public void setHistoriquePersonnelUnites(List<HistoriquePersonnelUnite> historiquePersonnelUnites) {
        this.historiquePersonnelUnites = historiquePersonnelUnites;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public UniteDeGestion getUniteDeGestion() {
        return uniteDeGestion;
    }

    public void setUniteDeGestion(UniteDeGestion uniteDeGestion) {
        this.uniteDeGestion = uniteDeGestion;
    }

    public List<HistoriquePersonnelMateriel> getHistoriquePersonnels() {
        return historiquePersonnels;
    }

    public void setHistoriquePersonnels(List<HistoriquePersonnelMateriel> historiquePersonnels) {
        this.historiquePersonnels = historiquePersonnels;
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
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Personnel[ id=" + id + " ]";
    }

}
