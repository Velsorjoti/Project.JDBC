package project.jdbc.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "fist_name")
    private String fistName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "gender")
    private String gender;
    @Column (name = "age")
    private Integer age;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "city_id")
    private City city;

    public Employee() {
    }

    public Employee(String fistName, String lastName, String gender, Integer age) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(Integer id, String fistName, String lastName, String gender, Integer age) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(fistName, employee.fistName) && Objects.equals(lastName, employee.lastName) && Objects.equals(gender, employee.gender) && Objects.equals(age, employee.age) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistName, lastName, gender, age, city);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }
}


// Забыл создать новую ветку, простите.
