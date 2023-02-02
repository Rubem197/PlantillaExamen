import org.hibernate.Session;

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
            System.out.println("Opc 1 insertar Nave");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    insertarNaves("Ruben", "Calle islas baleares N34");
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
