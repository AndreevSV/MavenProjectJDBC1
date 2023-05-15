package repository;

import model.City;

import java.util.List;

public interface CityDao {
        void addCity(City city);

        City getCityById(Integer id);

        List<City> getAllCityes();

        void updateCity(City city);

        void deleteCity(City city);
}
