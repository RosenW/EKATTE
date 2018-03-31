package ekatte.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "общини")
public class Municipality {
    @Id
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality")
    private Set<Settlement> settlements;

    public Set<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(Set<Settlement> settlements) {
        this.settlements = settlements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
