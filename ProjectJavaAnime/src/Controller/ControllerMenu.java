package Controller;

import Main.MVCFrontPage;
import Model.ModelMenuShow;
import View.ViewMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerMenu implements ActionListener {

    ViewMenu vm;
    ModelMenuShow mms;

    public ControllerMenu(ViewMenu vm, ModelMenuShow mms) {
        this.vm = vm;
        this.mms = mms;

        vm.jLabel1.addActionListener(this);
        vm.jButton1.addActionListener(this);
        vm.jButton2.addActionListener(this);
        vm.jButton3.addActionListener(this);
        vm.jButton4.addActionListener(this);
        vm.vsm.select.addActionListener(this);

        vm.vmd.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = vm.vmd.tabel.getSelectedRow();
                String judul = vm.vmd.tabel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Download Anime " + judul + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (mms.Download(judul) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Mendownload " + judul);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Mendownload " + judul);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Batal Download");
                }

                refreshTabel();
                refreshTabel2();
            }
        });
        vm.vml.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = vm.vml.tabel.getSelectedRow();
                String judul = vm.vml.tabel.getValueAt(row, 1).toString();
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Hapus Anime " + judul + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (mms.Hapus(judul) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Dihapus " + judul);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Menghapus " + judul);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Batal Hapus");
                }

                refreshTabel2();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm.jButton1) {
            vm.ShowMenu();
        } else if (e.getSource() == vm.jLabel1) {
            vm.HomeMenu();
        } else if (e.getSource() == vm.jButton2) {
            vm.ShowDownload();
        } else if (e.getSource() == vm.jButton3) {
            vm.ShowLibrary();
        } else if (e.getSource() == vm.jButton4) {
            vm.setVisible(false);
            MVCFrontPage mfp = new MVCFrontPage();
        }
        else if (e.getSource() == vm.vsm.select) {
            System.out.println("Terklik");
            String kategori = vm.vsm.getjComboBox1();
            System.out.println(kategori);
            if ("ALL".equals(kategori))
                refreshTabel3();
            else 
                refreshTabel4(kategori);
               
        }
    }

    public void refreshTabel() {
        mms.showModelMenuDownload();

        vm.vmd.tabel.setModel(new JTable(mms.data1, vm.vmd.namaKolom).getModel());

        vm.vmd.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vm.vmd.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vm.vmd.tabel.getColumnModel().getColumn(2).setPreferredWidth(80);
        vm.vmd.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public void refreshTabel2() {
        mms.showModelMenuLibrary();

        vm.vml.tabel.setModel(new JTable(mms.data2, vm.vml.namaKolom).getModel());

        vm.vml.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vm.vml.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vm.vml.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
    public void refreshTabel3() {
        mms.showModelMenuShow();

        vm.vsm.tabel.setModel(new JTable(mms.data, vm.vsm.namaKolom).getModel());
  
        vm.vsm.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vm.vsm.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vm.vsm.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }
    
    public void refreshTabel4(String kategori) {
        mms.showSelectedModelMenuShow(kategori);

       vm.vsm.tabel.setModel(new JTable(mms.data3, vm.vsm.namaKolom).getModel());


        vm.vsm.tabel.getColumnModel().getColumn(0).setPreferredWidth(200);
        vm.vsm.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        vm.vsm.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        vm.vsm.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
}
