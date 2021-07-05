package Model;

import Main.Akun;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelMenuShowAdmin {

    Akun akun;
    int jmlData;
    ModelHitungData mhd = new ModelHitungData();
    public String data[][] = new String[mhd.HitungData()][7];
    public String data3[][];
    private Statement statement;

    public ModelMenuShowAdmin(Akun akun) {
        this.akun = akun;

    }

    public void showModelMenuShowAdmin() {
        try {
            data = new String[mhd.HitungData()][7];
            int jmlData = 0;
            String query = "Select * from detail";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("judul");
                data[jmlData][1] = resultSet.getString("publisher");
                data[jmlData][2] = resultSet.getString("tahun");
                data[jmlData][3] = resultSet.getString("rilis");
                data[jmlData][4] = resultSet.getString("status");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("download");

                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void showSelectedModelMenuShowAdmin(String kategori) {
        try {
            data3 = new String[mhd.HitungData()][7];
            int jmlData = 0;
            System.out.println("LAPARRR");
            String query = "Select * from detail WHERE genre ='" + kategori +"'" ;
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data3[jmlData][0] = resultSet.getString("judul");
                data3[jmlData][1] = resultSet.getString("publisher");
                data3[jmlData][2] = resultSet.getString("tahun");
                data3[jmlData][3] = resultSet.getString("rilis");
                data3[jmlData][4] = resultSet.getString("status");
                data3[jmlData][5] = resultSet.getString("genre");
                data3[jmlData][6] = resultSet.getString("download");
                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public int Hapus(String Judul) {
        int result = 0;
        try {

            String query = "DELETE from detail where judul ='" + Judul + "'";
            statement = ConnectDatabase.Database().createStatement();
            statement.executeUpdate(query);

            result = 1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int TambahData(String judul, String publisher, String tahun, String rilis, String status, String genre) {
        int hitung = 0;
        try {
            if (CekData(judul) == 0) {
                String query = "INSERT INTO detail VALUES"
                        + "(NULL,'" + judul + "','" + publisher + "','" + tahun + "','" + rilis + "','" + status + "','" + genre + "','0')";
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

    public int CekData(String judul) {
        int hitung = 0;
        try {
            String query = "SELECT count(*) as hitung FROM detail "
                    + "WHERE judul = '" + judul + "'";
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

}
