package com.bioskop.app.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    private JLabel filmLabel, jadwalLabel;
    private JComboBox<String> filmCombo, jadwalCombo;
    private JButton pesanButton, batalButton, btnShowKursi;
    private JLabel hargaLabel;
    private boolean[] kursiStatus;

    public MainMenu(boolean[] kursiStatus) {
        super("Pemesanan Tiket Bioskop");

        this.kursiStatus = kursiStatus;

        // Panel utama
        JPanel mainPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Label film
        filmLabel = new JLabel("Film:");
        mainPanel.add(filmLabel);

        // Combo box film
        String[] films = {"Avengers: Endgame", "Spider-Man: Far From Home", "Joker"};
        filmCombo = new JComboBox<>(films);
        mainPanel.add(filmCombo);

        // Label jadwal
        jadwalLabel = new JLabel("Jadwal:");
        mainPanel.add(jadwalLabel);

        // Combo box jadwal
        String[] jadwal = {"10.00", "13.00", "16.00", "19.00", "22.00"};
        jadwalCombo = new JComboBox<>(jadwal);
        mainPanel.add(jadwalCombo);
        // Button show kursi
        btnShowKursi = new JButton("Lihat Kursi");
        btnShowKursi.addActionListener(this);
        mainPanel.add(btnShowKursi);

        // Button pesan tiket
        pesanButton = new JButton("Pesan Tiket");
        pesanButton.addActionListener(this);
        mainPanel.add(pesanButton);

        // Button batalkan
        batalButton = new JButton("Batal");
        batalButton.addActionListener(this);
        mainPanel.add(batalButton);

        // Set frame properties
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnShowKursi) {
            // Open kursi dialog
            KursiDialog kursiDialog = new KursiDialog(this, kursiStatus);
            kursiDialog.setVisible(true);
            kursiStatus = kursiDialog.getKursiStatus();
        } else if (e.getSource() == pesanButton) {
            // Get selected film and jadwal
            String selectedFilm = (String) filmCombo.getSelectedItem();
            String selectedJadwal = (String) jadwalCombo.getSelectedItem();

            // Calculate price based on film and jadwal
            int price = calculatePrice(selectedFilm, selectedJadwal);

            // Show confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(this, "Anda akan memesan tiket untuk film " + selectedFilm + " pada jadwal " + selectedJadwal + " dengan harga " + price + ". Lanjutkan?", "Konfirmasi Pemesanan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Show success message
                JOptionPane.showMessageDialog(this, "Tiket berhasil dipesan!");

                // Reset selected film and jadwal
                filmCombo.setSelectedIndex(0);
                jadwalCombo.setSelectedIndex(0);
            }
        } else if (e.getSource() == batalButton) {
            // Show confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Close the frame
                dispose();
            }
        }
    }

    private int calculatePrice(String film, String jadwal) {
        int price = 0;
        if (film.equals("Avengers: Endgame")) {
            price += 50000;
        } else if (film.equals("Spider-Man: Far From Home")) {
            price += 45000;
        } else if (film.equals("Joker")) {
            price += 55000;
        }

        if (jadwal.equals("10.00") || jadwal.equals("13.00")) {
            price -= 5000;
        }

        return price;
    }
}