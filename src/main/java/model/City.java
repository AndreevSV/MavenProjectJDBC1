package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "city_name")
    public String cityName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "city_id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Employee> employee;

    public City(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }
}
