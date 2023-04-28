package com.bioskop.app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kursi extends JPanel implements ActionListener {

    private JCheckBox kursiA, kursiB, kursiC, kursiD, kursiE;

    public Kursi() {
        super(new GridLayout(5, 1, 5, 5));
        kursiA = new JCheckBox("A");
        kursiB = new JCheckBox("B");
        kursiC = new JCheckBox("C");
        kursiD = new JCheckBox("D");
        kursiE = new JCheckBox("E");

        add(kursiA);
        add(kursiB);
        add(kursiC);
        add(kursiD);
        add(kursiE);
    }

    public JPanel getKursiPanel() {
        JPanel kursiPanel = new JPanel();
        kursiPanel.add(this);
        JOptionPane.showMessageDialog(null, kursiPanel, "Pilih kursi",
                JOptionPane.PLAIN_MESSAGE);
        return kursiPanel;
    }

    public boolean[] getKursiStatus() {
        boolean[] kursiStatus = {kursiA.isSelected(), kursiB.isSelected(),
                kursiC.isSelected(), kursiD.isSelected(), kursiE.isSelected()};
        return kursiStatus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //nothing
    }
}