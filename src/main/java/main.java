import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class main {

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(User.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(sr);

        Session session = sf.openSession();

        Transaction tr = session.beginTransaction();


        User joe = new User();
        joe.setUid(102);
        joe.setName("Joe Goldberg");
        joe.setEmail("joe.goldberg@gmail.com");

        session.save(joe);

        tr.commit();


    }
}
