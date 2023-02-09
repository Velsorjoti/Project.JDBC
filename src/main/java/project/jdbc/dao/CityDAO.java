package project.jdbc.dao;

import project.jdbc.model.City;
import project.jdbc.model.Employee;

import java.util.List;

public interface CityDAO {
    void createCity(City city);

    City readeCityById(Integer cityid);

    List<City> readAllCity();

    void updateCityById(City city);

    void deleteCityById(City city);
}
