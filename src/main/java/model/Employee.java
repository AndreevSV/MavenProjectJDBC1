package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {
    @Id
    @Column
    @GeneratedValue
    public Integer id;
    @Column
    public String first_name;
    @Column
    public  String last_name;
    @Column
    public String gender;
    @Column
    public Integer age;
    @Column
    public Integer city_id;

}
