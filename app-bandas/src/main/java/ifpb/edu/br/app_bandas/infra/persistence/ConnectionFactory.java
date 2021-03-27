package ifpb.edu.br.app_bandas.infra.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/app-bandas",
                    "usuario","1234"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);
        }

        return null;
    }
}
