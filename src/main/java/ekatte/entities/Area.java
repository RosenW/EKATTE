package ekatte.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "области")
public class Area {
    @Id
    private String id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Set<Municipality> municipalities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(Set<Municipality> municipalities) {
        this.municipalities = municipalities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
