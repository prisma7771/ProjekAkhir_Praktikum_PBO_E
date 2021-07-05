package View;

import Main.Akun;
import Model.ModelMenuShowAdmin;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewMenuAdminUpdate extends JPanel {

    Akun akun;
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Publisher", "Tahun", "Rilis", "Status", "Genre", "Download"};
    JLabel jLabel1, jLabel2;

    public ViewMenuAdminUpdate(Akun akun) {
        this.akun = akun;
        setBackground(new java.awt.Color(255, 255, 255, 195));
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        setVisible(true);
        setSize(380, 300);

        jLabel1 = new JLabel("MENU UPDATE");
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18));
        add(jLabel1);
        jLabel1.setBounds(20, 10, 110, 30);

        jLabel1 = new JLabel("Nb: Click title to edit");
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 11));
        add(jLabel1);
        jLabel1.setBounds(230, 20, 110, 30);

        ModelMenuShowAdmin mmsa = new ModelMenuShowAdmin(akun);
        mmsa.showModelMenuShowAdmin();

        tabel = new JTable(mmsa.data, namaKolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);

        scrollPane.setBounds(20, 45, 330, 210);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

}
