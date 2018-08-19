package ua.light.shop.dao.repo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.light.shop.entity.User;
import ua.light.shop.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    @Sql("/sql/cleanup.sql")
    public void cleanUp(){
        entityManager.createQuery("DELETE FROM User").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void testFindById(){
        //given
        User user = new User(null, "John", "Doe", 45);
        entityManager.persist(user);

        //when
        User actualUser = userDao.get(user.getId());

        //than
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testDelete() {
        //given
        User user = new User(null, "John", "Doe", 45);
        entityManager.persist(user);
        Long id = user.getId();

        //when
        userDao.delete(id);

        //than
        entityManager.clear();
        User deleteUser = entityManager.find(User.class, user.getId());
        Assert.assertNull(deleteUser);
    }

    @Test
    public void testUpdate(){
        //given
        User user = new User(null, "John", "Doe", 45);
        entityManager.persist(user);
        User newUser = new User(null, "Ivan", "Ivanov", 45);

        //when
        userDao.update(user.getId(), newUser);

        //than
        User actualUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals(newUser, actualUser);
    }

    @Test
    public void testCreate() {
        //given
        User user = new User(null, "John", "Doe", 45);

        //when
        userDao.create(user);

        //than
        User actualUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testFindAll() {
        //given
        User user = new User(null, "John", "Doe", 45);
        User user2 = new User(null, "Danny", "Dep", 25);

       List<User> expectedUser = Arrays.asList(user, user2);
       expectedUser.forEach(entityManager::persist);

        //when
        List<User> foundUsers = userDao.findAll();

        //than
       Assert.assertEquals(2, foundUsers.size());
       Assert.assertTrue(foundUsers.containsAll(expectedUser));
    }
}