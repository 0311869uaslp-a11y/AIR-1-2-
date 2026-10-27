package tp4.univ.paris13.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "ADRESSE")
public class Adresse {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "RUE")
    private String rue;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS")
    private String pays;

    @OneToMany(mappedBy = "adresse")
    private List<Personne> personne;
    
    
    // Constructor vacío (requerido por Hibernate/JPA)
    public Adresse() {}

    
    
    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}