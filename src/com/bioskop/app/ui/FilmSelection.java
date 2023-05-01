package com.bioskop.app.ui;

import com.bioskop.app.model.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmSelection extends JPanel implements ActionListener {
    private JComboBox<Film> filmCombo;
    private JLabel titleLabel;
    private JLabel imageLabel;
    private JTextArea descriptionTextArea;

    public FilmSelection() {
        setLayout(new BorderLayout(10, 10)); // set layout ke border layout
        // Combo box film
        Film[] films = {
                new Film("Pilih Film", "", ""),
                new Film("Avengers: Endgame", "Deskripsi Avengers: Endgame (kiamat)", "C:\\Users\\muhamad^rifai\\Documents\\UPH-CODE\\bioskop-app-handler\\resources\\avenger.jpg"),
                new Film("Spider-Man: Far From Home", "Deskripsi Spider-Man: Far From Home home to far", "C:\\Users\\muhamad^rifai\\Documents\\UPH-CODE\\bioskop-app-handler\\resources\\spiderman.jpg"),
                new Film("Joker", "Deskripsi Joker :  film ter GG pada jamn itu", "C:\\Users\\muhamad^rifai\\Documents\\UPH-CODE\\bioskop-app-handler\\resources\\joker.jpg")
        };
        filmCombo = new JComboBox<>(films);
        filmCombo.addActionListener(this);
        add(filmCombo, BorderLayout.WEST);

        // Panel detail film
        JPanel filmDetailPanel = new JPanel(new BorderLayout());

        // Label judul film
        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        filmDetailPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel gambar dan deskripsi
        JPanel imageAndDescriptionPanel = new JPanel(new BorderLayout());

        // Label gambar
        imageLabel = new JLabel();
        imageAndDescriptionPanel.add(imageLabel, BorderLayout.WEST);

        // Text area deskripsi
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setEditable(false);
        imageAndDescriptionPanel.add(descriptionTextArea, BorderLayout.CENTER);

        filmDetailPanel.add(imageAndDescriptionPanel, BorderLayout.CENTER);

        add(filmDetailPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox source = (JComboBox) e.getSource();
        Film selectedFilm = (Film) source.getSelectedItem();

        titleLabel.setText(selectedFilm.getTitle());

        ImageIcon icon = new ImageIcon(selectedFilm.getImagePath());
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // ganti ukuran menjadi 100x100 pixel
        imageLabel.setIcon(new ImageIcon(image));
        descriptionTextArea.setText(selectedFilm.getDescription());
    }

    public String getSelectedFilmTitle() {
        Film selectedFilm = (Film) filmCombo.getSelectedItem();
        return selectedFilm.getTitle();
    }
}