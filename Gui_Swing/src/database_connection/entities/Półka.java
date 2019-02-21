/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_connection.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "P\u00f3\u0142ka", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P\u00f3\u0142ka.findAll", query = "SELECT p FROM P\u00f3\u0142ka p")
    , @NamedQuery(name = "P\u00f3\u0142ka.findByIdP\u00f3\u0142ka", query = "SELECT p FROM P\u00f3\u0142ka p WHERE p.idP\u00f3\u0142ka = :idP\u00f3\u0142ka")
    , @NamedQuery(name = "P\u00f3\u0142ka.findByNazwa", query = "SELECT p FROM P\u00f3\u0142ka p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "P\u00f3\u0142ka.findByPojemno\u015b\u0107", query = "SELECT p FROM P\u00f3\u0142ka p WHERE p.pojemno\u015b\u0107 = :pojemno\u015b\u0107")})
public class Półka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idP\u00f3\u0142ka")
    private Integer idPółka;
    @Basic(optional = false)
    @Column(name = "Nazwa")
    private String nazwa;
    @Column(name = "Pojemno\u015b\u0107")
    private Short pojemność;
    @OneToMany(mappedBy = "p\u00f3\u0142kaidP\u00f3\u0142ka")
    private Collection<Książka> książkaCollection;

    public Półka() {
    }

    public Półka(Integer idPółka) {
        this.idPółka = idPółka;
    }

    public Półka(Integer idPółka, String nazwa) {
        this.idPółka = idPółka;
        this.nazwa = nazwa;
    }

    public Integer getIdPółka() {
        return idPółka;
    }

    public void setIdPółka(Integer idPółka) {
        this.idPółka = idPółka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Short getPojemność() {
        return pojemność;
    }

    public void setPojemność(Short pojemność) {
        this.pojemność = pojemność;
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
        hash += (idPółka != null ? idPółka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Półka)) {
            return false;
        }
        Półka other = (Półka) object;
        if ((this.idPółka == null && other.idPółka != null) || (this.idPółka != null && !this.idPółka.equals(other.idPółka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.P\u00f3\u0142ka[ idP\u00f3\u0142ka=" + idPółka + " ]";
    }
    
}
