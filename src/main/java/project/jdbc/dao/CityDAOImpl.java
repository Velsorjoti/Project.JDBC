package project.jdbc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.jdbc.config.HibernateSessionFactoryUtil;
import project.jdbc.model.City;
import project.jdbc.model.Employee;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void createCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City readeCityById(Integer cityid) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, cityid);
        }
    }

    @Override
    public List<City> readAllCity() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<City> cityListik = (List<City>) session.createQuery("From City ").list();
            return cityListik;
        }
    }

    @Override
    public void updateCityById(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCityById(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
