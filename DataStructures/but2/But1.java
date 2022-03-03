import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class But1{



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            int count = 0;
            int x = 0;
            
            public void run() {
                int sayi = 0;
                JFrame pen = new JFrame("Number of primes");
                while (sayi > 100 || sayi <= 0) {
                    sayi = Integer.parseInt(JOptionPane.showInputDialog(pen, "Enter a number to"));
                }
                pen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        for (int i = 2; i <= sayi; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count += 1;
                }
            }
            if (count == 2) {
                x += 1;
            }
            count = 0;
        }
        pen.setTitle("Message");
        JOptionPane.showMessageDialog(pen, (x + " is number of primes less than or equal to your input"));
        System.exit(0);
            }
        });
    }
}