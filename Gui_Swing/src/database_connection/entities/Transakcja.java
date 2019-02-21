/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_connection.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erucolindo
 */
@Entity
@Table(name = "Transakcja", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transakcja.findAll", query = "SELECT t FROM Transakcja t")
    , @NamedQuery(name = "Transakcja.findByIdTransakcja", query = "SELECT t FROM Transakcja t WHERE t.idTransakcja = :idTransakcja")
    , @NamedQuery(name = "Transakcja.findByCzyDostawa", query = "SELECT t FROM Transakcja t WHERE t.czyDostawa = :czyDostawa")
    , @NamedQuery(name = "Transakcja.findByData", query = "SELECT t FROM Transakcja t WHERE t.data = :data")
    , @NamedQuery(name = "Transakcja.findByWarto\u015b\u0107Tr", query = "SELECT t FROM Transakcja t WHERE t.warto\u015b\u0107Tr = :warto\u015b\u0107Tr")
    , @NamedQuery(name = "Transakcja.findByIlo\u015b\u0107ksi\u0105\u017cek", query = "SELECT t FROM Transakcja t WHERE t.ilo\u015b\u0107ksi\u0105\u017cek = :ilo\u015b\u0107ksi\u0105\u017cek")})
public class Transakcja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTransakcja")
    private Integer idTransakcja;
    @Basic(optional = false)
    @Column(name = "CzyDostawa")
    private boolean czyDostawa;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Warto\u015b\u0107_Tr")
    private float wartośćTr;
    @Basic(optional = false)
    @Column(name = "Ilo\u015b\u0107_ksi\u0105\u017cek")
    private short ilośćksiążek;
    @JoinColumn(name = "Dostawca_idDostawca", referencedColumnName = "idDostawca")
    @ManyToOne
    private Dostawca dostawcaidDostawca;
    @JoinColumn(name = "Klient_idKlient", referencedColumnName = "idKlient")
    @ManyToOne
    private Klient klientidKlient;
    @JoinColumn(name = "Ksi\u0105\u017cka_idKsi\u0105\u017cka", referencedColumnName = "idKsi\u0105\u017cka")
    @ManyToOne(optional = false)
    private Książka książkaidKsiążka;

    public Transakcja() {
    }

    public Transakcja(Integer idTransakcja) {
        this.idTransakcja = idTransakcja;
    }

    public Transakcja(Integer idTransakcja, boolean czyDostawa, Date data, float wartośćTr, short ilośćksiążek) {
        this.idTransakcja = idTransakcja;
        this.czyDostawa = czyDostawa;
        this.data = data;
        this.wartośćTr = wartośćTr;
        this.ilośćksiążek = ilośćksiążek;
    }

    public Integer getIdTransakcja() {
        return idTransakcja;
    }

    public void setIdTransakcja(Integer idTransakcja) {
        this.idTransakcja = idTransakcja;
    }

    public boolean getCzyDostawa() {
        return czyDostawa;
    }

    public void setCzyDostawa(boolean czyDostawa) {
        this.czyDostawa = czyDostawa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getWartośćTr() {
        return wartośćTr;
    }

    public void setWartośćTr(float wartośćTr) {
        this.wartośćTr = wartośćTr;
    }

    public short getIlośćksiążek() {
        return ilośćksiążek;
    }

    public void setIlośćksiążek(short ilośćksiążek) {
        this.ilośćksiążek = ilośćksiążek;
    }

    public Dostawca getDostawcaidDostawca() {
        return dostawcaidDostawca;
    }

    public void setDostawcaidDostawca(Dostawca dostawcaidDostawca) {
        this.dostawcaidDostawca = dostawcaidDostawca;
    }

    public Klient getKlientidKlient() {
        return klientidKlient;
    }

    public void setKlientidKlient(Klient klientidKlient) {
        this.klientidKlient = klientidKlient;
    }

    public Książka getKsiążkaidKsiążka() {
        return książkaidKsiążka;
    }

    public void setKsiążkaidKsiążka(Książka książkaidKsiążka) {
        this.książkaidKsiążka = książkaidKsiążka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransakcja != null ? idTransakcja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transakcja)) {
            return false;
        }
        Transakcja other = (Transakcja) object;
        if ((this.idTransakcja == null && other.idTransakcja != null) || (this.idTransakcja != null && !this.idTransakcja.equals(other.idTransakcja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Transakcja[ idTransakcja=" + idTransakcja + " ]";
    }
    
}
