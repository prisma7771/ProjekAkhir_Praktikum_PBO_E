package View;

import Model.ModelMenuShow;
import Main.Akun;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewMenuShow extends JPanel {

    Akun akun;
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Publisher", "Tahun", "Rilis", "Status","Genre"};
    public JComboBox<String> jComboBox1;
    public JButton select;

    public ViewMenuShow(Akun akun) {
        this.akun = akun;
        setBackground(new java.awt.Color(255, 255, 255, 195));
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        setVisible(true);
        setSize(380, 300);
        
        jComboBox1 = new JComboBox<>();
        select = new JButton();
        
        ModelMenuShow mms = new ModelMenuShow(akun);
        mms.showModelMenuShow();

        tabel = new JTable(mms.data, namaKolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);

        scrollPane.setBounds(20, 15, 330, 210);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"ALL","Adventure", "Comedy", "Action", "Horror"}));
        jComboBox1.setBounds(15,235,100,20);
        add(jComboBox1);
        
        select.setText("SHOW");
        select.setBounds(145,235,100,20);
        add(select);
    }

    public String getjComboBox1() {
        String value = jComboBox1.getSelectedItem().toString();
        return value;
    }
    
    
}
