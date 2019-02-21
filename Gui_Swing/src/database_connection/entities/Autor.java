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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erucolindo
 */
@Entity
@Table(name = "Autor", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
    , @NamedQuery(name = "Autor.findByImi\u0119", query = "SELECT a FROM Autor a WHERE a.imi\u0119 = :imi\u0119")
    , @NamedQuery(name = "Autor.findByNazwisko", query = "SELECT a FROM Autor a WHERE a.nazwisko = :nazwisko")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAutor")
    private Integer idAutor;
    @Basic(optional = false)
    @Column(name = "Imi\u0119")
    private String imię;
    @Basic(optional = false)
    @Column(name = "Nazwisko")
    private String nazwisko;
    @JoinTable(name = "Ksi\u0105\u017cka_has_Autor", joinColumns = {
        @JoinColumn(name = "Autor_idAutor", referencedColumnName = "idAutor")}, inverseJoinColumns = {
        @JoinColumn(name = "Ksi\u0105\u017cka_idKsi\u0105\u017cka", referencedColumnName = "idKsi\u0105\u017cka")})
    @ManyToMany
    private Collection<Książka> książkaCollection;

    public Autor() {
    }

    public Autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autor(Integer idAutor, String imię, String nazwisko) {
        this.idAutor = idAutor;
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database_connection.entities.Autor[ idAutor=" + idAutor + " ]";
    }
    
}
