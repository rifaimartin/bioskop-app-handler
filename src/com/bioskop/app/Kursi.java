package com.bioskop.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kursi extends JFrame implements ActionListener {
    private JCheckBox kursiA, kursiB, kursiC, kursiD, kursiE;
    private JPanel kursiPanel;
    private JButton pilihKursi, batal;
    private JFrame kursiFrame;

    public Kursi() {
        kursiFrame = this;
        kursiPanel = new JPanel();
        kursiA = new JCheckBox("A");
        kursiPanel.add(kursiA);
        kursiB = new JCheckBox("B");
        kursiPanel.add(kursiB);
        kursiC = new JCheckBox("C");
        kursiPanel.add(kursiC);
        kursiD = new JCheckBox("D");
        kursiPanel.add(kursiD);
        kursiE = new JCheckBox("E");
        kursiPanel.add(kursiE);

        pilihKursi = new JButton("Pesan");
        kursiPanel.add(pilihKursi);

        batal = new JButton("Batal");
        kursiPanel.add(batal);

        batal.addActionListener(e -> {
            kursiFrame.setVisible(false);
            dispose();
        });

        setSize(400,200);

        add(kursiPanel);
        kursiFrame.setVisible(true);

    }

    public JPanel getKursiPanel() {
        return kursiPanel;
    }

    public boolean isKursiASelected() {
        return kursiA.isSelected();
    }

    public boolean isKursiBSelected() {
        return kursiB.isSelected();
    }

    public boolean isKursiCSelected() {
        return kursiC.isSelected();
    }

    public boolean isKursiDSelected() {
        return kursiD.isSelected();
    }

    public boolean isKursiESelected() {
        return kursiE.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}