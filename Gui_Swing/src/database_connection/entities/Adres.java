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
@Table(name = "Adres", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
    , @NamedQuery(name = "Adres.findByIdAdres", query = "SELECT a FROM Adres a WHERE a.idAdres = :idAdres")
    , @NamedQuery(name = "Adres.findByUlica", query = "SELECT a FROM Adres a WHERE a.ulica = :ulica")
    , @NamedQuery(name = "Adres.findByKodPocztowy", query = "SELECT a FROM Adres a WHERE a.kodPocztowy = :kodPocztowy")
    , @NamedQuery(name = "Adres.findByMiasto", query = "SELECT a FROM Adres a WHERE a.miasto = :miasto")
    , @NamedQuery(name = "Adres.findByPa\u0144stwo", query = "SELECT a FROM Adres a WHERE a.pa\u0144stwo = :pa\u0144stwo")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAdres")
    private Integer idAdres;
    @Basic(optional = false)
    @Column(name = "Ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "Kod_Pocztowy")
    private String kodPocztowy;
    @Basic(optional = false)
    @Column(name = "Miasto")
    private String miasto;
    @Basic(optional = false)
    @Column(name = "Pa\u0144stwo")
    private String państwo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdres")
    private Collection<Dostawca> dostawcaCollection;
    @OneToMany(mappedBy = "adresidAdres")
    private Collection<Klient> klientCollection;

    public Adres() {
    }

    public Adres(Integer idAdres) {
        this.idAdres = idAdres;
    }

    public Adres(Integer idAdres, String ulica, String kodPocztowy, String miasto, String państwo) {
        this.idAdres = idAdres;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.państwo = państwo;
    }

    public Integer getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(Integer idAdres) {
        this.idAdres = idAdres;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getPaństwo() {
        return państwo;
    }

    public void setPaństwo(String państwo) {
        this.państwo = państwo;
    }

    @XmlTransient
    public Collection<Dostawca> getDostawcaCollection() {
        return dostawcaCollection;
    }

    public void setDostawcaCollection(Collection<Dostawca> dostawcaCollection) {
        this.dostawcaCollection = dostawcaCollection;
    }

    @XmlTransient
    public Collection<Klient> getKlientCollection() {
        return klientCollection;
    }

    public void setKlientCollection(Collection<Klient> klientCollection) {
        this.klientCollection = klientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdres != null ? idAdres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.idAdres == null && other.idAdres != null) || (this.idAdres != null && !this.idAdres.equals(other.idAdres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Adres[ idAdres=" + idAdres + " ]";
    }
    
}
