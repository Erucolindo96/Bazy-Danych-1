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
@Table(name = "Dostawca", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawca.findAll", query = "SELECT d FROM Dostawca d")
    , @NamedQuery(name = "Dostawca.findByIdDostawca", query = "SELECT d FROM Dostawca d WHERE d.idDostawca = :idDostawca")
    , @NamedQuery(name = "Dostawca.findByNazwa", query = "SELECT d FROM Dostawca d WHERE d.nazwa = :nazwa")
    , @NamedQuery(name = "Dostawca.findByNip", query = "SELECT d FROM Dostawca d WHERE d.nip = :nip")
    , @NamedQuery(name = "Dostawca.findByEmail", query = "SELECT d FROM Dostawca d WHERE d.email = :email")
    , @NamedQuery(name = "Dostawca.findByNrTel", query = "SELECT d FROM Dostawca d WHERE d.nrTel = :nrTel")})
public class Dostawca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDostawca")
    private Integer idDostawca;
    @Basic(optional = false)
    @Column(name = "Nazwa")
    private String nazwa;
    @Basic(optional = false)
    @Column(name = "NIP")
    private String nip;
    @Column(name = "E_mail")
    private String email;
    @Basic(optional = false)
    @Column(name = "Nr_Tel")
    private String nrTel;
    @OneToMany(mappedBy = "dostawcaidDostawca")
    private Collection<Transakcja> transakcjaCollection;
    @JoinColumn(name = "idAdres", referencedColumnName = "idAdres")
    @ManyToOne(optional = false)
    private Adres idAdres;

    public Dostawca() {
    }

    public Dostawca(Integer idDostawca) {
        this.idDostawca = idDostawca;
    }

    public Dostawca(Integer idDostawca, String nazwa, String nip, String nrTel) {
        this.idDostawca = idDostawca;
        this.nazwa = nazwa;
        this.nip = nip;
        this.nrTel = nrTel;
    }

    public Integer getIdDostawca() {
        return idDostawca;
    }

    public void setIdDostawca(Integer idDostawca) {
        this.idDostawca = idDostawca;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public Adres getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(Adres idAdres) {
        this.idAdres = idAdres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDostawca != null ? idDostawca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawca)) {
            return false;
        }
        Dostawca other = (Dostawca) object;
        if ((this.idDostawca == null && other.idDostawca != null) || (this.idDostawca != null && !this.idDostawca.equals(other.idDostawca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Dostawca[ idDostawca=" + idDostawca + " ]";
    }
    
}
