import javax.swing.*;
import java.awt.*;

public class Kursi {
    private JCheckBox kursiA, kursiB, kursiC, kursiD, kursiE;
    private JPanel kursiPanel;

    public Kursi() {
        kursiPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        kursiPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
}