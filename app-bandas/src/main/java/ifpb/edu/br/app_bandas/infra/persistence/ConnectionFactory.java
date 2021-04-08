package ifpb.edu.br.app_bandas.infra.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
<<<<<<< HEAD
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/app-bandas",
                    "usuario","1234");

=======

    private Connection connection;
    private static String URL;
    private static String usuario;
    private static String senha;
    private static String driver;

    static {
        URL = "jdbc:postgresql://host-banco:5432/app-bandas";
        usuario =  "postgres";
        senha =  "postgres";
        driver =  "org.postgresql.Driver";

    }

    public void conectar() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(URL, usuario, senha);
        this.connection = connection;
    }

    public void desconectar() throws SQLException {
        if (!this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public Connection getConexao() {
        return this.connection;
>>>>>>> d8eb9f8c5942386e6868c85aa8c8112434a4a55c
    }

//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            return DriverManager.getConnection(
//                    "jdbc:postgresql://host-banco:5432/app-bandas",
//                    "usuario","1234"
//            );
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);
//        }
//
//        return null;
//    }
}
