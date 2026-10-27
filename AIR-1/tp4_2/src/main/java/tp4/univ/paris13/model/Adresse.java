package tp4.univ.paris13.model;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "RUE")
    private String rue;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS")
    private String pays;

    public Adresse() {}
    public Adresse(int numero, String rue, String codePostal, String ville, String pays) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getRue() { return rue; }
    public void setRue(String rue) { this.rue = rue; }
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }
}