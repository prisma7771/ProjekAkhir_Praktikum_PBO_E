package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelRegister {

    private Statement statement;

    public int CekAkun(String email, String username) {
        int hitung = 0;
        try {
            String query = "SELECT count(*) as hitung FROM akun "
                    + "WHERE email = '" + email + "' OR username = '" + username + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                hitung = resultSet.getInt("hitung");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }

    public int TambahAkun(String username, String name, String email, String password, String noHp) {
        int hitung = 0;
        try {
            if (CekAkun(email, username) == 0) {
                String query = "INSERT INTO akun VALUES"
                        + "('" + username + "','" + email + "','" + name + "','" + noHp + "','" + password + "')";
                statement = (Statement) ConnectDatabase.Database().createStatement();
                statement.executeUpdate(query);
                hitung = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }
}
