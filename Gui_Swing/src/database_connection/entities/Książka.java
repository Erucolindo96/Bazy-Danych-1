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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Ksi\u0105\u017cka", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ksi\u0105\u017cka.findAll", query = "SELECT k FROM Ksi\u0105\u017cka k")
    , @NamedQuery(name = "Ksi\u0105\u017cka.findByIdKsi\u0105\u017cka", query = "SELECT k FROM Ksi\u0105\u017cka k WHERE k.idKsi\u0105\u017cka = :idKsi\u0105\u017cka")
    , @NamedQuery(name = "Ksi\u0105\u017cka.findByTytu\u0142", query = "SELECT k FROM Ksi\u0105\u017cka k WHERE k.tytu\u0142 = :tytu\u0142")
    , @NamedQuery(name = "Ksi\u0105\u017cka.findByCena", query = "SELECT k FROM Ksi\u0105\u017cka k WHERE k.cena = :cena")
    , @NamedQuery(name = "Ksi\u0105\u017cka.findByIlo\u015b\u0107ksi\u0105\u017cek", query = "SELECT k FROM Ksi\u0105\u017cka k WHERE k.ilo\u015b\u0107ksi\u0105\u017cek = :ilo\u015b\u0107ksi\u0105\u017cek")})
public class Książka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idKsi\u0105\u017cka")
    private Integer idKsiążka;
    @Basic(optional = false)
    @Column(name = "Tytu\u0142")
    private String tytuł;
    @Basic(optional = false)
    @Column(name = "Cena")
    private float cena;
    @Basic(optional = false)
    @Column(name = "Ilo\u015b\u0107_ksi\u0105\u017cek")
    private short ilośćksiążek;
    @ManyToMany(mappedBy = "ksi\u0105\u017ckaCollection")
    private Collection<Autor> autorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ksi\u0105\u017ckaidKsi\u0105\u017cka")
    private Collection<Transakcja> transakcjaCollection;
    @JoinColumn(name = "P\u00f3\u0142ka_idP\u00f3\u0142ka", referencedColumnName = "idP\u00f3\u0142ka")
    @ManyToOne
    private Półka półkaidPółka;
    @JoinColumn(name = "Wydawnictwo_idWydawnictwo", referencedColumnName = "idWydawnictwo")
    @ManyToOne(optional = false)
    private Wydawnictwo wydawnictwoidWydawnictwo;

    public Książka() {
    }

    public Książka(Integer idKsiążka) {
        this.idKsiążka = idKsiążka;
    }

    public Książka(Integer idKsiążka, String tytuł, float cena, short ilośćksiążek) {
        this.idKsiążka = idKsiążka;
        this.tytuł = tytuł;
        this.cena = cena;
        this.ilośćksiążek = ilośćksiążek;
    }

    public Integer getIdKsiążka() {
        return idKsiążka;
    }

    public void setIdKsiążka(Integer idKsiążka) {
        this.idKsiążka = idKsiążka;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public short getIlośćksiążek() {
        return ilośćksiążek;
    }

    public void setIlośćksiążek(short ilośćksiążek) {
        this.ilośćksiążek = ilośćksiążek;
    }

    @XmlTransient
    public Collection<Autor> getAutorCollection() {
        return autorCollection;
    }

    public void setAutorCollection(Collection<Autor> autorCollection) {
        this.autorCollection = autorCollection;
    }

    @XmlTransient
    public Collection<Transakcja> getTransakcjaCollection() {
        return transakcjaCollection;
    }

    public void setTransakcjaCollection(Collection<Transakcja> transakcjaCollection) {
        this.transakcjaCollection = transakcjaCollection;
    }

    public Półka getPółkaidPółka() {
        return półkaidPółka;
    }

    public void setPółkaidPółka(Półka półkaidPółka) {
        this.półkaidPółka = półkaidPółka;
    }

    public Wydawnictwo getWydawnictwoidWydawnictwo() {
        return wydawnictwoidWydawnictwo;
    }

    public void setWydawnictwoidWydawnictwo(Wydawnictwo wydawnictwoidWydawnictwo) {
        this.wydawnictwoidWydawnictwo = wydawnictwoidWydawnictwo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKsiążka != null ? idKsiążka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Książka)) {
            return false;
        }
        Książka other = (Książka) object;
        if ((this.idKsiążka == null && other.idKsiążka != null) || (this.idKsiążka != null && !this.idKsiążka.equals(other.idKsiążka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Ksi\u0105\u017cka[ idKsi\u0105\u017cka=" + idKsiążka + " ]";
    }
    
}
