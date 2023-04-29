package com.bioskop.app.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class KursiDialog extends JDialog implements ActionListener {
    private boolean[] kursiStatus;
    private JButton[] kursiButtons;

    public KursiDialog(JFrame parent, boolean[] kursiStatus) {
        super(parent, "Pilih Kursi", true);
        this.kursiStatus = kursiStatus;

        JPanel mainPanel = new JPanel(new GridLayout(5, 6, 10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        kursiButtons = new JButton[30];

        for (int i = 0; i < 30; i++) {
            kursiButtons[i] = new JButton("" + (i + 1));
            kursiButtons[i].setEnabled(kursiStatus[i]);
            kursiButtons[i].addActionListener(this);
            mainPanel.add(kursiButtons[i]);
        }

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        mainPanel.add(clearButton);

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean[] getKursiStatus() {
        return kursiStatus;
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.getText().equals("Clear")) {
            Arrays.fill(kursiStatus, true);

            for (int i = 0; i < kursiButtons.length; i++) {
                kursiButtons[i].setEnabled(kursiStatus[i]);
            }

            repaint();
        } else {

            int kursiIndex = Integer.parseInt(source.getText()) - 1;
            kursiStatus[kursiIndex] = false;

            source.setEnabled(false);

            // Menutup dialog
            dispose();
        }
    }
}