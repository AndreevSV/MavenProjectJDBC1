package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employee;



}
