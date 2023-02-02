import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class clsConexion {
    private  static SessionFactory sessionFactory;

    private static Transaction transaction;
    private static Session session;


    public static Transaction abrirTransaccion(){

        return  transaction = session.beginTransaction();
    }

    public static void commit(){

        transaction.commit();
    }

    public static void rollback(){
        transaction.rollback();
    }

    public static Session abrirConexion(){

        return session = sessionFactory.openSession();
    }

    public static void cerrarConexion(){

        sessionFactory.close();
    }


    public static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
}
