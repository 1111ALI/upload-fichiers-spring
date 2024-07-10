package cm.adacorp.thymeleaf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Menu> menus;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "restaurant_plat",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "plat_id")
    )
    private Set<Plat> plats = new HashSet<>();
}
