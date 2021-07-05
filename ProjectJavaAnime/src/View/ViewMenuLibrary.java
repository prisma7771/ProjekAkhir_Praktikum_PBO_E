package View;

import Model.ModelMenuShow;
import Main.Akun;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewMenuLibrary extends JPanel {

    Akun akun;
    public JTable tabel;
    JLabel jLabel1;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Username", "Judul"};

    public ViewMenuLibrary(Akun akun) {
        this.akun = akun;
        setBackground(new java.awt.Color(255, 255, 255, 195));
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        setVisible(true);
        setSize(380, 300);
        ModelMenuShow mms = new ModelMenuShow(akun);
        mms.showModelMenuLibrary();

        tabel = new JTable(mms.data2, namaKolom);
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);

        scrollPane.setBounds(20, 15, 330, 210);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jLabel1 = new JLabel("Nb: Click title to delete from library");
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 12));
        add(jLabel1);
        jLabel1.setBounds(25, 240, 200, 30);
    }

    
}
