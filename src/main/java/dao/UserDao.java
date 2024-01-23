package dao;


import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDao {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    static EntityManager manager = factory.createEntityManager();

    public User findById(int userId) {
        return manager.find(User.class, userId);
    }

    public User findByName(String name) {
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.name = :name");
        query.setParameter("name", name);

        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> findAll() {
        List<User> users = manager.createQuery("SELECT u FROM User u", User.class).getResultList();
        System.out.println(users);
        return users;
    }

    public void create(User user) {
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            System.out.println("Пользователь был создан");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        }
    }

    public void update(User user) {

    }

    public void delete(User user) {

    }
}