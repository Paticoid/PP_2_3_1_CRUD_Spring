package dmitry.dao;

import dmitry.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
//       return sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u", User.class).getResultList();
     return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

    }

    @Override
    public void save(User user) {
//        sessionFactory.getCurrentSession().save(user);
         entityManager.persist(user);

    }

    @Override
    public  User get(long id) {
//        return sessionFactory.getCurrentSession().get(User.class,id);
        return entityManager.find(User.class,id);

    }

    @Override
    public void update(long id,User updateUser) {
//        User user=sessionFactory.getCurrentSession().get(User.class,id);
//        user.setName(updateUser.getName());
//        user.setAge(updateUser.getAge());
//        user.setEmail(updateUser.getEmail());

        User user = entityManager.find(User.class,id);
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());


    }


    @Override
    public void delete(long id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(session.get(User.class,id));

        entityManager.remove(entityManager.find(User.class,id));


    }
}
