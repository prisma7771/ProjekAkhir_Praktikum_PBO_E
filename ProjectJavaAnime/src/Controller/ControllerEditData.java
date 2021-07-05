package Controller;

import View.ViewEditDialog;
import Model.ModelEditData;
import Model.ModelMenuShowAdmin;
import View.ViewMenuAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControllerEditData implements ActionListener {

    ViewEditDialog ved;
    ModelEditData med;
    ViewMenuAdmin vma;
    ModelMenuShowAdmin mmsa;

    public ControllerEditData(ViewMenuAdmin vma, ModelMenuShowAdmin mmsa, ViewEditDialog ved, ModelEditData med) {

        this.vma = vma;
        this.mmsa = mmsa;
        this.ved = ved;
        this.med = med;

        ved.update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ved.update) {
            String id = ved.getId();
            String judul = ved.getJudul();
            String publisher = ved.getPublisher();
            String tahun = ved.getTahun();
            String rilis = ved.getRilis();
            String status = ved.getStatus();
            String genre = ved.getGenre();
            System.out.println(id);
            System.out.println(judul);
            System.out.println(publisher);
            System.out.println(tahun);
            System.out.println(rilis);
            System.out.println(genre);

            int help = 0;

            if (judul.equals("") || publisher.equals("") || tahun.equals("") || rilis.equals("") || status.equals("") || genre.equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                help = 1;
            }
            if (!tahun.matches("^[0-9]+$")) {
                showMessageDialog(null, "Tahun Must Digit");
                help = 1;
            } else if (help == 0) {

                if (med.UpdateData(id, judul, publisher, tahun, rilis, status, genre) == 1) {
                    JOptionPane.showMessageDialog(null, "Anime " + judul + " berhasil di-update!");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Update!");
                }
            }

            refreshTabel();
            refreshTabel2();
            refreshTabel3();
            help = 0;
            ved.dispose();
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

    public void reset() {
        vma.vmta.judul.setText("");
        vma.vmta.publisher.setText("");
        vma.vmta.tahun.setText("");
        vma.vmta.rilistahun.setText("");
    }

}
