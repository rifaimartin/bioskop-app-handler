
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BioskopApp extends JFrame implements ActionListener {
    
    private JLabel filmLabel, jadwalLabel, kursiLabel;
    private JComboBox<String> filmCombo, jadwalCombo;
    private JCheckBox kursiA, kursiB, kursiC, kursiD, kursiE;
    private JButton pesanButton, batalButton;
    private JLabel hargaLabel;
    
    public BioskopApp() {
        super("Pemesanan Tiket Bioskop");
        
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
        String[] jadwals = {"10.00", "12.00", "14.00", "16.00", "18.00", "20.00", "22.00"};
        jadwalCombo = new JComboBox<>(jadwals);
        mainPanel.add(jadwalCombo);
        
        // Label kursi
        kursiLabel = new JLabel("Kursi:");
        mainPanel.add(kursiLabel);
        
        // Check box kursi
        kursiA = new JCheckBox("A");
        mainPanel.add(kursiA);
        kursiB = new JCheckBox("B");
        mainPanel.add(kursiB);
        kursiC = new JCheckBox("C");
        mainPanel.add(kursiC);
        kursiD = new JCheckBox("D");
        mainPanel.add(kursiD);
        kursiE = new JCheckBox("E");
        mainPanel.add(kursiE);

        hargaLabel = new JLabel("Harga: ");
        mainPanel.add(hargaLabel);  
        hargaLabel = new JLabel("");
        mainPanel.add(hargaLabel); 
        
        // Button pesan
        pesanButton = new JButton("Pesan");
        pesanButton.addActionListener(this);
        mainPanel.add(pesanButton);
        
        // Button batal
        batalButton = new JButton("Batal");
        batalButton.addActionListener(this);
        mainPanel.add(batalButton);
        
        // Menambahkan panel utama ke frame
        add(mainPanel);
        
        // Mengatur ukuran frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
    LoginUser loginUser = new LoginUser();
    
    // Jalankan LoginUser terlebih dahulu
    loginUser.setVisible(true);
    BioskopApp bioskopApp = new BioskopApp();
    // Setelah LoginUser selesai, jalankan BioskopApp
    bioskopApp.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // event from customer checkbox kursi, and then show value amount nya
        if (e.getSource() == kursiA || e.getSource() == kursiB || e.getSource() == kursiC || e.getSource() == kursiD || e.getSource() == kursiE) {
            // Menghitung harga tiket berdasarkan jumlah kursi yang dipilih
            int harga = 0;
            if (kursiA.isSelected()) {
                harga += 50000;
            }
            if (kursiB.isSelected()) {
                harga += 50000;
            }
            if (kursiC.isSelected()) {
                harga += 50000;
            }
            if (kursiD.isSelected()) {
                harga += 50000;
            }
            if (kursiE.isSelected()) {
                harga += 50000;
            }
            hargaLabel.setText(Integer.toString(2000));
        }

        if (e.getSource() == pesanButton) {
            String film = (String) filmCombo.getSelectedItem();
            String jadwal = (String) jadwalCombo.getSelectedItem();
            String kursi = "";
            int harga = 0;

            if (kursiA.isSelected()) {
                kursi += "A, ";
                harga += 30000;
            }

            if (kursiB.isSelected()) {
                kursi += "B, ";
                harga += 30000;
            }

            if (kursiC.isSelected()) {
                kursi += "C, ";
                harga += 25000;
            }

            if (kursiD.isSelected()) {
                kursi += "D, ";
                harga += 30000;
            }

            if (kursiE.isSelected()) {
                kursi += "E, ";
                harga += 30000;
            }
            if (kursi.equals("")) {
                JOptionPane.showMessageDialog(this, "Anda belum memilih kursi.");
            } else {
                String message = "Anda memesan tiket untuk film " + film + " pada jadwal " + jadwal + " dengan kursi "
                        + kursi + ".";
                message += "\nTotal harga yang harus dibayar adalah " + harga + ".";
                hargaLabel.setText(Integer.toString(harga));
                JOptionPane.showMessageDialog(this, message);
            }
        } else if (e.getSource() == batalButton) {
            int option = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin membatalkan pemesanan?");
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    }