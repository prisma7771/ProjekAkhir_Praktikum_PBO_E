package View;

import Model.ModelEditData;
import Main.Akun;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

public class ViewEditDialog extends JDialog {

    Akun akun;
    ViewMenuAdmin vma;
    ModelEditData med;
    public JButton update;
    public JComboBox<String> status;
    public JComboBox<String> genre;
    public JTextField rilis;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    public JTextField judul;
    public JTextField publisher;
    public JTextField tahun;
    String Judul;
    public String id;

    public ViewEditDialog(String Judul) {
        this.Judul = Judul;
        med = new ModelEditData();
        med.SelectData(Judul);
        setLayout(null);
        setVisible(true);
        setSize(380, 300);

        update = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        rilis = new JTextField();
        judul = new JTextField();
        publisher = new JTextField();
        tahun = new JTextField();
        status = new JComboBox<>();
        genre = new JComboBox<>();

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18));
        jLabel7.setText("UPDATE DATA");
        add(jLabel7);
        jLabel7.setBounds(20, 10, 110, 30);

        jLabel1.setText("Judul");
        add(jLabel1);
        jLabel1.setBounds(10, 50, 40, 14);

        jLabel2.setText("Publisher");
        add(jLabel2);
        jLabel2.setBounds(10, 80, 60, 14);

        jLabel3.setText("Tahun");
        add(jLabel3);
        jLabel3.setBounds(10, 110, 60, 14);

        jLabel4.setText("Tgl Rilis");
        add(jLabel4);
        jLabel4.setBounds(10, 140, 60, 14);

        jLabel5.setText("Status");
        add(jLabel5);
        jLabel5.setBounds(10, 170, 60, 14);

        jLabel6.setText("Genre");
        add(jLabel6);
        jLabel6.setBounds(10, 200, 60, 14);

        judul.setText(med.data[1]);
        add(judul);
        judul.setBounds(90, 50, 230, 20);

        publisher.setText(med.data[2]);
        add(publisher);
        publisher.setBounds(90, 80, 230, 20);

        tahun.setText(med.data[3]);
        add(tahun);
        tahun.setBounds(90, 110, 230, 20);

        rilis.setText(med.data[4]);
        add(rilis);
        rilis.setBounds(90, 140, 230, 20);

        status.setModel(new DefaultComboBoxModel<>(new String[]{"On-Going", "Finished"}));
        status.setSelectedItem(med.data[5]);
        add(status);
        status.setBounds(90, 170, 90, 20);

        genre.setModel(new DefaultComboBoxModel<>(new String[]{"Adventure", "Comedy", "Action", "Horror"}));
        genre.setSelectedItem(med.data[6]);
        add(genre);
        genre.setBounds(90, 200, 90, 20);

        update.setText("UPDATE");
        update.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        add(update);
        update.setBounds(240, 170, 50, 50);

        id = med.data[0];
    }

    public String getStatus() {
        String value = status.getSelectedItem().toString();
        return value;
    }

    public String getGenre() {
        String value2 = genre.getSelectedItem().toString();
        return value2;
    }

    public String getRilis() {
        return rilis.getText();
    }

    public String getJudul() {
        return judul.getText();
    }

    public String getPublisher() {
        return publisher.getText();
    }

    public String getTahun() {
        return tahun.getText();
    }

    public String getId() {
        return id;
    }
}
