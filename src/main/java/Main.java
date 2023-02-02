import org.hibernate.Session;

import javax.transaction.Transaction;
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
        session= clsConexion.abrirConexion();


        int opc =1;
        while (opc != 0) {
            System.out.println("-----Menu-----");
            System.out.println("Opc 1 borrar Usuario");
            System.out.println("Opc 2 guardar Usuario");
            System.out.println("Opc 3 actualizar Usuario");
            System.out.println("Opc 4 leer Usuario");
            System.out.println("Opc 5 borrar Post");
            System.out.println("Opc 6 guardar Post");
            System.out.println("Opc 7 actualizar Post");
            System.out.println("Opc 8 leer Post");
            System.out.println("Opc 9 borrar Likes");
            System.out.println("Opc 10 guardar Likes");
            System.out.println("Opc 11 actualizar Likes");
            System.out.println("Opc 12 leer Likes");
            opc = sc.nextInt();
            switch (opc) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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

}
