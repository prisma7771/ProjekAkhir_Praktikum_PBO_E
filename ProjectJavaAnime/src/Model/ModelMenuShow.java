package Model;

import Main.Akun;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelMenuShow {

    Akun akun;
    int jmlData;
    ModelHitungData mhd = new ModelHitungData();
    public String data[][] = new String[mhd.HitungData()][6];
    public String data3[][];
    public String data1[][] = new String[mhd.HitungData()][3];
    public String data2[][];
    private Statement statement;

    public ModelMenuShow(Akun akun) {
        this.akun = akun;

    }

    public void showModelMenuShow() {
        try {
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

                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public void showSelectedModelMenuShow(String kategori) {
        try {
            data3 = new String[mhd.HitungData()][6];
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
                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    
    public int HitungData() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM akun";
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

    public void showModelMenuDownload() {
        try {
            int jmlData = 0;
            String query = "Select * from `detail`";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data1[jmlData][0] = resultSet.getString("judul");
                data1[jmlData][1] = resultSet.getString("genre");
                data1[jmlData][2] = resultSet.getString("download");
                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int Download(String Judul) {
        int result = 0;
        try {
            if (cekDownload(Judul) == 0) {

                String query = "INSERT INTO library VALUES "
                        + "('" + akun.getusername() + "','"
                        + Judul + "')";
                statement = ConnectDatabase.Database().createStatement();
                statement.executeUpdate(query);
                PlusDownload(Judul);

                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    private int cekDownload(String Judul) {
        int hitung = 0;
        try {
            String query = "SELECT COUNT(*) as hitung from library WHERE judul = '" + Judul + "' AND username ='" + akun.getusername() + "'";
            statement = ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                hitung = resultSet.getInt("hitung");
                if (hitung == 1) {

                    JOptionPane.showMessageDialog(null, "Anda Sudah Mendownload Anime Ini!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }

    private int PlusDownload(String Judul) {
        int hitung = 0;
        try {
            String query = "SELECT * from detail WHERE judul = '" + Judul + "'";
            statement = ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                hitung = resultSet.getInt("download");
            }
            hitung++;
            String query2 = "UPDATE detail SET download = '" + hitung + "' WHERE judul = '" + Judul + "'";
            statement = ConnectDatabase.Database().createStatement();
            statement.executeUpdate(query2);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }

    public void showModelMenuLibrary() {
        try {
            data2 = new String[HitungLibrary()][2];
            int jmlData = 0;
            String query = "Select * from `library` where username ='" + akun.getusername() + "'";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data2[jmlData][0] = resultSet.getString("username");
                data2[jmlData][1] = resultSet.getString("judul");
                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public final int HitungLibrary() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) as count FROM library where username ='" + akun.getusername() + "'";
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

    public int Hapus(String Judul) {
        int result = 0;
        try {

            String query = "DELETE from library where judul ='" + Judul + "' AND username = '"
                    + akun.getusername() + "'";

            statement = ConnectDatabase.Database().createStatement();
            statement.executeUpdate(query);

            result = 1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

}
