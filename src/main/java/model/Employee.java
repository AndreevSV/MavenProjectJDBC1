package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    public Integer id;
    public String first_name;
    public  String last_name;
    public String gender;
    public Integer age;
    public Integer city_id;

}
