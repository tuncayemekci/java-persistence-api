import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {

        User u = new User();
        u.setUid(101);
        u.setName("Tuncay");
        u.setEmail("tuncayemekci@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        User user = em.find(User.class, 1);

    }
}
