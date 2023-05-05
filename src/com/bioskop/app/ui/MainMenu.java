package com.bioskop.app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainMenu extends JFrame implements ActionListener {
    private JLabel filmLabel, jadwalLabel;
    private JComboBox<String> jadwalCombo;
    private JButton pesanButton, batalButton, btnShowKursi;
    private FilmSelection filmSelectionPanel;
    private boolean[] kursiStatus;

    public MainMenu(boolean[] kursiStatus) {
        setTitle("Bioskop App");
        setSize(500, 400);

        this.kursiStatus = kursiStatus;

        Arrays.fill(kursiStatus, true);

        // main pannel
        JPanel mainPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // sizing pannel
        mainPanel.setPreferredSize(new Dimension(700, 500));

        // Label film


        // Label film
        filmLabel = new JLabel("Film:");
        filmLabel.setFont(new Font("Verdana", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        mainPanel.add(filmLabel);
        // Combo box f
        filmSelectionPanel = new FilmSelection();
//        filmSelectionPanel.setBorder(BorderFactory.createTitledBorder("Film"));
        filmSelectionPanel.setPreferredSize(new Dimension(600, 300));
        mainPanel.add(filmSelectionPanel);

        // Label jadwal
        jadwalLabel = new JLabel("Jadwal:");
        jadwalLabel.setFont(new Font("Verdana", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        mainPanel.add(jadwalLabel);

        // Combo box jadwal
        String[] jadwal = {"Pilh Jadwal","10.00", "13.00", "16.00", "19.00", "22.00"};
        jadwalCombo = new JComboBox<>(jadwal);
        mainPanel.add(jadwalCombo);

        // Button show kursi
        btnShowKursi = new JButton("Lihat Kursi");
        btnShowKursi.setFont(new Font("Calibri", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        btnShowKursi.addActionListener(this);
        mainPanel.add(btnShowKursi);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        // pesan tiket
        pesanButton = new JButton("Pesan Tiket");
        pesanButton.setFont(new Font("Calibri", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        pesanButton.addActionListener(this);
        pesanButton.setBackground(new Color(144, 238, 144));
        buttonPanel.add(pesanButton);

        // batalkan
        batalButton = new JButton("Batal");
        batalButton.setFont(new Font("Calibri", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        batalButton.addActionListener(this);
        batalButton.setBackground(new Color(255, 182, 193));
        buttonPanel.add(batalButton);

        // Menambahkan buttonPanel ke dalam mainPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(buttonPanel, gbc);

        // Set frame prop
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

            String kursiTerpilih = "";
            for (int i = 0; i < kursiStatus.length; i++) {
                if (!kursiStatus[i]) {
                    kursiTerpilih += (i + 1) + ", ";
                }
            }

            // Get film and jadwal
//            String selectedFilm = (String) filmCombo.getSelectedItem();
            String selectedJadwal = (String) jadwalCombo.getSelectedItem();

            String selectedTitle = filmSelectionPanel.getSelectedFilmTitle();

            // Calculate price based on film and jadwal
            int price = calculatePrice(selectedTitle, selectedJadwal);

            // Show confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(this, "Anda akan memesan tiket untuk film " + selectedTitle + " pada jadwal " + selectedJadwal + " dengan harga " + price +  "nomor kursi :"  + kursiTerpilih + ". Lanjutkan?", "Konfirmasi Pemesanan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Tiket berhasil dipesan!");
            }
        } else if (e.getSource() == batalButton) {
            // Show confirm dialog
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Close frame
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