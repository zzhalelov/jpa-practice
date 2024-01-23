package dao;


import model.User;

import javax.persistence.*;
import java.util.List;

public class UserDao {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    static EntityManager manager = factory.createEntityManager();

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

    public List<User> findAll() {
        List<User> users = manager.createQuery("SELECT u FROM User u", User.class).getResultList();
        System.out.println(users);
        return users;
    }

    public User findById(int userId) {
        return manager.find(User.class, userId);
    }

    public User findByName(String name) {
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.name = :name");
        query.setParameter("name", name);

        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public int deleteById(int userId) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            User user = manager.find(User.class, userId);
            if (user != null) {
                manager.remove(user);
                System.out.println("Пользователь с указанным ID удален: " + userId);
            } else {
                System.out.println("Пользователь с указанным ID не найден: " + userId);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manager.getTransaction().rollback();
        }
        return userId;
    }

    public void update(User user) {

    }

}