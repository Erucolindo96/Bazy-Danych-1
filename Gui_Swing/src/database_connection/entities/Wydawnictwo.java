/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_connection.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erucolindo
 */
@Entity
@Table(name = "Wydawnictwo", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wydawnictwo.findAll", query = "SELECT w FROM Wydawnictwo w")
    , @NamedQuery(name = "Wydawnictwo.findByIdWydawnictwo", query = "SELECT w FROM Wydawnictwo w WHERE w.idWydawnictwo = :idWydawnictwo")
    , @NamedQuery(name = "Wydawnictwo.findByNazwa", query = "SELECT w FROM Wydawnictwo w WHERE w.nazwa = :nazwa")})
public class Wydawnictwo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idWydawnictwo")
    private Integer idWydawnictwo;
    @Basic(optional = false)
    @Column(name = "Nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wydawnictwoidWydawnictwo")
    private Collection<Książka> książkaCollection;

    public Wydawnictwo() {
    }

    public Wydawnictwo(Integer idWydawnictwo) {
        this.idWydawnictwo = idWydawnictwo;
    }

    public Wydawnictwo(Integer idWydawnictwo, String nazwa) {
        this.idWydawnictwo = idWydawnictwo;
        this.nazwa = nazwa;
    }

    public Integer getIdWydawnictwo() {
        return idWydawnictwo;
    }

    public void setIdWydawnictwo(Integer idWydawnictwo) {
        this.idWydawnictwo = idWydawnictwo;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Książka> getKsiążkaCollection() {
        return książkaCollection;
    }

    public void setKsiążkaCollection(Collection<Książka> książkaCollection) {
        this.książkaCollection = książkaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWydawnictwo != null ? idWydawnictwo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wydawnictwo)) {
            return false;
        }
        Wydawnictwo other = (Wydawnictwo) object;
        if ((this.idWydawnictwo == null && other.idWydawnictwo != null) || (this.idWydawnictwo != null && !this.idWydawnictwo.equals(other.idWydawnictwo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Wydawnictwo[ idWydawnictwo=" + idWydawnictwo + " ]";
    }
    
}
