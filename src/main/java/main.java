import model.Message;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Random;

public class main {

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Message.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(sr);

        Session session = sf.openSession();

        Transaction tr = session.beginTransaction();

        User user = (User) session.get(User.class, 1);

        System.out.println(user);

        session.save(user);

        //session.save(generateRandomUser());

        tr.commit();


    }

    public static User generateRandomUser(){
        User rnd = new User();
        rnd.setName(getRandomString(5));
        rnd.setEmail(getRandomEmail(5));
        return rnd;
    }

    public static String getRandomString(int number){
        Random rnd = new Random();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String str = "";
        for (int i = 0; i < number; i++) {
            str += alphabet.charAt(rnd.nextInt(alphabet.length()));
        }
        return str;
    }

    public static String getRandomEmail(int number){
        return getRandomString(number) + "@gmail.com";
    }

}
