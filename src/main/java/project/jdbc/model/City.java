package project.jdbc.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table (name = "city")
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "city_id")
    private Integer cityid;
    @Column (name = "city_name")
    private String cityName;

    public City() {
    }


    public City(String cityName) {
        this.cityName = cityName;
    }

    @OneToMany (mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employeeListik;

    public int getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Employee> getEmployeeListik() {
        return employeeListik;
    }

    public void setEmployeeListik(List<Employee> employeeListik) {
        this.employeeListik = employeeListik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityid, city.cityid) && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityid, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityid=" + cityid +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
