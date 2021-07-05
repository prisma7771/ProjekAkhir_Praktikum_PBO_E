package Controller;

import Main.MVCFrontPage;
import Main.MVCEditData;
import Model.ModelMenuShowAdmin;
import View.ViewMenuAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControllerMenuAdmin implements ActionListener {

    ViewMenuAdmin vma;
    ModelMenuShowAdmin mmsa;

    public ControllerMenuAdmin(ViewMenuAdmin vma, ModelMenuShowAdmin mmsa) {
        this.vma = vma;
        this.mmsa = mmsa;

        vma.jLabel1.addActionListener(this);
        vma.jButton1.addActionListener(this);
        vma.jButton2.addActionListener(this);
        vma.jButton3.addActionListener(this);
        vma.jButton4.addActionListener(this);
        vma.jButton5.addActionListener(this);
        vma.vmta.tambah.addActionListener(this);
        vma.vmsa.select.addActionListener(this);

        vma.vmah.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = vma.vmah.tabel.getSelectedRow();
                String judul = vma.vmah.tabel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Hapus Anime " + judul + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (mmsa.Hapus(judul) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Dihapus " + judul);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Menghapus " + judul);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Batal Hapus");
                }
                refreshTabel();
                refreshTabel2();
                refreshTabel3();
            }
        });

        vma.vmau.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = vma.vmau.tabel.getSelectedRow();
                String judul = vma.vmau.tabel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Edit Anime " + judul + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    MVCEditData mved = new MVCEditData(vma, mmsa, judul);
                } else {
                    JOptionPane.showMessageDialog(null, "Batal Edit");
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vma.jButton1) {
            vma.ShowMenuAdmin();
        } else if (e.getSource() == vma.jLabel1) {
            vma.HomeMenu();
        } else if (e.getSource() == vma.jButton2) {
            vma.ShowTambah();
        } else if (e.getSource() == vma.jButton3) {
            vma.ShowUpdate();
        } else if (e.getSource() == vma.jButton5) {
            vma.ShowHapus();
        } else if (e.getSource() == vma.jButton4) {
            MVCFrontPage mfp = new MVCFrontPage();
            vma.setVisible(false);

        } else if (e.getSource() == vma.vmta.tambah) {

            String judul = vma.vmta.getJudul();
            String publisher = vma.vmta.getPublisher();
            String tahun = vma.vmta.getTahun();
            String rilisbulan = vma.vmta.getBulan();
            String rilistahun = vma.vmta.getRilis();
            String rilis = rilisbulan + " " + rilistahun;
            String status = vma.vmta.getStatus();
            String genre = vma.vmta.getGenre();
            int help = 0;

            if (judul.equals("") || publisher.equals("") || tahun.equals("") || rilis.equals("") || status.equals("") || genre.equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                help = 1;
            }
            if (!tahun.matches("^[0-9]+$")) {
                showMessageDialog(null, "Tahun Must Digit");
                help = 1;
            }
            if (!rilistahun.matches("^[0-9]+$")) {
                showMessageDialog(null, "Tahun Must Digit");
                help = 1;
            } else if (help == 0) {
                if (mmsa.TambahData(judul, publisher, tahun, rilis, status, genre) == 1) {
                    JOptionPane.showMessageDialog(null, "Anime " + judul + " berhasil ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Anime sudah di dalam list!");
                }
            }
            refreshTabel();
            refreshTabel2();
            refreshTabel3();
            reset();
            help = 0;
        }
 else if (e.getSource() == vma.vmsa.select) {
          
            String kategori = vma.vmsa.getjComboBox1();
            
            if ("ALL".equals(kategori))
                refreshTabel4();
            else 
                refreshTabel5(kategori);
               
        }
    }

    public void refreshTabel() {
        mmsa.showModelMenuShowAdmin();

        vma.vmsa.tabel.setModel(new JTable(mmsa.data, vma.vmsa.namaKolom).getModel());
        vma.vmsa.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vma.vmsa.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        vma.vmsa.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public void refreshTabel2() {
        mmsa.showModelMenuShowAdmin();

        vma.vmah.tabel.setModel(new JTable(mmsa.data, vma.vmah.namaKolom).getModel());
        vma.vmah.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vma.vmah.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vma.vmah.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vma.vmah.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vma.vmah.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vma.vmah.tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        vma.vmah.tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        vma.vmah.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public void refreshTabel3() {
        mmsa.showModelMenuShowAdmin();

        vma.vmau.tabel.setModel(new JTable(mmsa.data, vma.vmau.namaKolom).getModel());
        vma.vmau.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vma.vmau.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vma.vmau.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vma.vmau.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vma.vmau.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vma.vmau.tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        vma.vmau.tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        vma.vmau.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
     public void refreshTabel4() {
        mmsa.showModelMenuShowAdmin();

        vma.vmsa.tabel.setModel(new JTable(mmsa.data, vma.vmsa.namaKolom).getModel());
  
        vma.vmsa.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vma.vmsa.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        vma.vmsa.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }
    
    public void refreshTabel5(String kategori) {
        mmsa.showSelectedModelMenuShowAdmin(kategori);

        vma.vmsa.tabel.setModel(new JTable(mmsa.data3, vma.vmsa.namaKolom).getModel());
  
        vma.vmsa.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vma.vmsa.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        vma.vmsa.tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        vma.vmsa.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
}

    public void reset() {
        vma.vmta.judul.setText("");
        vma.vmta.publisher.setText("");
        vma.vmta.tahun.setText("");
        vma.vmta.rilistahun.setText("");
    }
}
