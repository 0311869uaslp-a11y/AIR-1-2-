package tp4.univ.paris13.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNE")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MAIL")
    private String mail;

    @ManyToOne
    @JoinColumn(name = "ID_ADRESSE")
    private Adresse adresse;

    public Personne() {}
    public Personne(String nom, String prenom, String tel, String mail, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.adresse = adresse;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
}