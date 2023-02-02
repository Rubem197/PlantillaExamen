import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static Session session;

    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
        Scanner sc = new Scanner(System.in);

        clsConexion.setUp();
        session = clsConexion.abrirConexion();


        int opc = 1;
        while (opc != 0) {
            System.out.println("-----Menu-----");
            System.out.println("Opc 1 insertar Nave");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    insertarNaves("David", "Calle islas baleares N34");
                    break;
                case 2:
                    borrarNaves(1);
                    break;
                case 3:
                    mostrarListadoNaves(listarEntitys("listaNaves"));
                    break;
                case 4:
                    mostrarListadoNaves(listarConParametro("ListarPorNombre", "ganadero", "Ruben"));
                    break;
                case 5:
                    System.out.println(resultado("numeroNaves"));
                    break;

            }

        }
        clsConexion.cerrarConexion();

    }

    private static void insertarNaves(String ganadero, String ubicacion) {
        NavesEntity persona = new NavesEntity(ganadero, ubicacion);
        clsConexion.abrirTransaccion();
        int id = (int) session.save(persona);
        clsConexion.commit();
        System.out.println(id);

    }

    private static void borrarNaves(int id) {
        clsConexion.abrirTransaccion();
        try {
            NavesEntity persona = session.get(NavesEntity.class, id);
            session.delete(persona);
            clsConexion.commit();
        } catch (Exception e) {
            clsConexion.rollback();
            System.out.println("No se ha podido borrar");
        }

    }

    private static void mostrarListadoNaves(List<NavesEntity> listaNaves) {
        for (int i = 0; i < listaNaves.size(); i++) {
            System.out.println(listaNaves.get(i).getGanadero());

        }
    }

    private static List listarEntitys(String nombre) {
        TypedQuery lista = session.getNamedQuery(nombre);

        return lista.getResultList();
    }

    public static List listarConParametro(String namedQuery, String param, String valor) {
        TypedQuery lista = session.getNamedQuery(namedQuery).setParameter(param, valor);

        return lista.getResultList();
    }

    public static long resultado(String namedQuery) {
        Query lista = session.getNamedQuery(namedQuery);
        return (long)lista.uniqueResult();
    }
}
