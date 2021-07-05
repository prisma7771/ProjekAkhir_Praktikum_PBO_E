package Model;

import Main.Akun;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelEditData {

    Akun akun;
    int jmlData;
    ModelHitungData mhd = new ModelHitungData();
    public String data[] = new String[7];
    private Statement statement;

    public ModelEditData() {

    }

    public void SelectData(String judul) {
        try {
            String query = "SELECT * FROM detail "
                    + "WHERE judul = '" + judul + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                data[0] = resultSet.getString("id_anime");
                data[1] = resultSet.getString("judul");
                data[2] = resultSet.getString("publisher");
                data[3] = resultSet.getString("tahun");
                data[4] = resultSet.getString("rilis");
                data[5] = resultSet.getString("status");
                data[6] = resultSet.getString("genre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int UpdateData(String id, String judul, String publisher, String tahun, String rilis, String status, String genre) {
        int hitung = 0;
        try {
            String query = "UPDATE detail SET judul ='" + judul + "',publisher = '" + publisher + "',tahun ='" + tahun + "',rilis ='" + rilis + "',status = '" + status + "',genre ='" + genre
                    + "' WHERE id_anime = '" + id + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            statement.executeUpdate(query);
            hitung = 1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }

}
