package tp4.univ.paris13.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "PERSONNE")
public class Personne {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "ID_ADRESSE")
    private Integer idAdresse;

    
    @ManyToOne
    @JoinColumn(name = "ADRESSE_ID") // Clave foránea en la tabla PERSONNE
    private Adresse adresse;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }
}