package repository;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class CityDaoImpl implements CityDao{
    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(city);
            transaction.commit();
        }
    }

    @Override
    public City getCityById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            City city = session.get(City.class, id);
            transaction.commit();
            return city;
        }
    }

    @Override
    public List<City> getAllCityes() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<City> cities = session.createQuery("FROM City", City.class).list();
            transaction.commit();
            return cities;
        }
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
