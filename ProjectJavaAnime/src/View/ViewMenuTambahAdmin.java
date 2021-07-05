package View;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ViewMenuTambahAdmin extends JPanel {

    public JButton tambah;
    public JComboBox<String> status;
    public JComboBox<String> genre;
    public JComboBox<String> rilisbulan;
    public JTextField rilistahun;
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

    public ViewMenuTambahAdmin() {
        
        setBackground(new java.awt.Color(255, 255, 255, 195));
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        setVisible(true);
        setSize(380, 300);

        tambah = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        rilisbulan = new JComboBox<String>();
        rilistahun = new JTextField();
        judul = new JTextField();
        publisher = new JTextField();
        tahun = new JTextField();
        status = new JComboBox<>();
        genre = new JComboBox<>();

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18));
        jLabel7.setText("MENU TAMBAH");
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

        add(judul);
        judul.setBounds(90, 50, 230, 20);

        add(publisher);
        publisher.setBounds(90, 80, 230, 20);

        add(tahun);
        tahun.setBounds(90, 110, 230, 20);

        rilisbulan.setModel(new DefaultComboBoxModel<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Agt", "Sep", "Okt", "Nov", "Dec"}));
        add(rilisbulan);
        rilisbulan.setBounds(90, 140, 100, 20);

        add(rilistahun);
        rilistahun.setBounds(210, 140, 100, 20);

        status.setModel(new DefaultComboBoxModel<>(new String[]{"On-Going", "Finished"}));
        add(status);
        status.setBounds(90, 170, 90, 20);

        genre.setModel(new DefaultComboBoxModel<>(new String[]{"Adventure", "Comedy", "Action", "Horror"}));
        add(genre);
        genre.setBounds(90, 200, 90, 20);

        tambah.setText("ENTER");
        tambah.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        add(tambah);
        tambah.setBounds(240, 170, 50, 50);
    }

    public String getStatus() {
        String value = status.getSelectedItem().toString();
        return value;
    }

    public String getGenre() {
        String value2 = genre.getSelectedItem().toString();
        return value2;
    }

    public String getBulan() {
        String value3 = rilisbulan.getSelectedItem().toString();
        return value3;
    }

    public String getRilis() {
        return rilistahun.getText();
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
}
