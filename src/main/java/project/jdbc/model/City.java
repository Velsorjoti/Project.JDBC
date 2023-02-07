package project.jdbc.model;

import java.util.Objects;

public class City {
    private int cityid;
    private String cityName;

    public City(int cityid, String cityName) {
        this.cityid = cityid;
        this.cityName = cityName;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityid == city.cityid && Objects.equals(cityName, city.cityName);
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
