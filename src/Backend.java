import java.sql.*;
import java.sql.Driver;

import org.postgresql.*;
public class Backend {
    public static void main(String[] args) throws SQLException{
        System.out.println("Hello, World!");

        /*
        String url = "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00";
        String username = "urcyphloccxygf";
        String password = "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351";
        String query = "select * from store";


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String data = "";

                for (int i = 1; i <= 7; i++) {
                    data += result.getString(i) + ":";
                }
                System.out.println(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO merchandise VALUES (?)");
            statement.setString(1, "B");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

        Connection conn = null;

        try {
            conn = connect();
            insertCustomerName(conn, "Josiah");
            insertCustomerName(conn, "Jorge");
            insertCustomerName(conn, "Quin");
            printCustomerTable(conn);
        } finally {
            try {
                if (conn != null) { conn.close(); }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00",
                    "urcyphloccxygf",
                    "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void printCustomerTable(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from customer");

            while (result.next()) {
                String data = "";

                for (int i = 1; i <= 7; i++) {
                    data += result.getString(i) + ":";
                }
                System.out.println(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCustomerName(Connection conn, String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO customer (first) VALUES (?)");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
