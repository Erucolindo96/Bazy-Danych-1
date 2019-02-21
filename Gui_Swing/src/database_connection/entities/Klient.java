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
import javax.persistence.JoinColumn;
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
@Table(name = "Klient", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k")
    , @NamedQuery(name = "Klient.findByIdKlient", query = "SELECT k FROM Klient k WHERE k.idKlient = :idKlient")
    , @NamedQuery(name = "Klient.findByNazwa", query = "SELECT k FROM Klient k WHERE k.nazwa = :nazwa")
    , @NamedQuery(name = "Klient.findByImi\u0119", query = "SELECT k FROM Klient k WHERE k.imi\u0119 = :imi\u0119")
    , @NamedQuery(name = "Klient.findByNazwisko", query = "SELECT k FROM Klient k WHERE k.nazwisko = :nazwisko")
    , @NamedQuery(name = "Klient.findByEmail", query = "SELECT k FROM Klient k WHERE k.email = :email")
    , @NamedQuery(name = "Klient.findByNrTel", query = "SELECT k FROM Klient k WHERE k.nrTel = :nrTel")})
public class Klient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idKlient")
    private Integer idKlient;
    @Basic(optional = false)
    @Column(name = "Nazwa")
    private String nazwa;
    @Column(name = "Imi\u0119")
    private String imię;
    @Column(name = "Nazwisko")
    private String nazwisko;
    @Column(name = "E_mail")
    private String email;
    @Column(name = "Nr_Tel")
    private String nrTel;
    @OneToMany(mappedBy = "klientidKlient")
    private Collection<Transakcja> transakcjaCollection;
    @JoinColumn(name = "Adres_idAdres", referencedColumnName = "idAdres")
    @ManyToOne
    private Adres adresidAdres;

    public Klient() {
    }

    public Klient(Integer idKlient) {
        this.idKlient = idKlient;
    }

    public Klient(Integer idKlient, String nazwa) {
        this.idKlient = idKlient;
        this.nazwa = nazwa;
    }

    public Integer getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(Integer idKlient) {
        this.idKlient = idKlient;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    @XmlTransient
    public Collection<Transakcja> getTransakcjaCollection() {
        return transakcjaCollection;
    }

    public void setTransakcjaCollection(Collection<Transakcja> transakcjaCollection) {
        this.transakcjaCollection = transakcjaCollection;
    }

    public Adres getAdresidAdres() {
        return adresidAdres;
    }

    public void setAdresidAdres(Adres adresidAdres) {
        this.adresidAdres = adresidAdres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlient != null ? idKlient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.idKlient == null && other.idKlient != null) || (this.idKlient != null && !this.idKlient.equals(other.idKlient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Klient[ idKlient=" + idKlient + " ]";
    }
    
}
