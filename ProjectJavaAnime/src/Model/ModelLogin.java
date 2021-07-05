package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelLogin {

    private Statement statement;
    public String data[] = new String[2];

    public void CekAkun(String email, String password) {
        try {
            String query = "SELECT * FROM akun "
                    + "WHERE (username = '" + email + "' AND password = '" + password + "') OR (password = '" + password + "' AND email ='" + email + "')";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                data[0] = resultSet.getString("username");
                data[1] = resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int HitungAkun(String email, String password) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM akun "
                    + "WHERE username = '" + email + "' AND password = '" + password + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void CekAdmin(String email, String password) {
        try {
            String query = "SELECT * FROM admin "
                    + "WHERE username = '" + email + "' AND password = '" + password + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                data[0] = resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int HitungAdmin(String email, String password) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM admin "
                    + "WHERE username = '" + email + "' AND password = '" + password + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }
}
