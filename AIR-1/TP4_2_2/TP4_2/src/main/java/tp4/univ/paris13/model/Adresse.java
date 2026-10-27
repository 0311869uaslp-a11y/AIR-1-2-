package tp4.univ.paris13.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADRESSE")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "rue")
    private String rue;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @OneToMany(mappedBy = "adresse")
    private List<Personne> personnes;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public String getRue() { return rue; }
    public void setRue(String rue) { this.rue = rue; }
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }
    public List<Personne> getPersonnes() { return personnes; }
    public void setPersonnes(List<Personne> personnes) { this.personnes = personnes; }
}
