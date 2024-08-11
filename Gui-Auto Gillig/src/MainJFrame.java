import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainJFrame extends JFrame {

    public AddPartsWindow newPartsWindow;

    private final JPanel panel1; 

    private final JLabel label1;

    public final JButton button1;
    public final JButton button2;
    public final JButton button3;

    public MainJFrame(){
        setTitle("Gillig Auto"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("Icon//icon.png").getImage()); 
        setLocationRelativeTo(null);
        setAlwaysOnTop(true); 

        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0)); 

        //Button 1
        button1 = new JButton("Add New Parts");
        button1.setPreferredSize(new Dimension(200, 50));

        //Button 2
        button2 = new JButton("Edit Existing Parts");
        button2.setPreferredSize(new Dimension(200, 50));

        label1 = new JLabel("AUTO GILLIG HOME");

        button3 = new JButton("Prepare CSV File");
        button3.setPreferredSize(new Dimension(200, 50));

        panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(340, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));

        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3); 
        add(panel1); 

        pack();

        setVisible(true);

    }


}
        

