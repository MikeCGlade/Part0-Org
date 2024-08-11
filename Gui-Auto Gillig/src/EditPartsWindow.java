import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class EditPartsWindow extends JFrame implements ActionListener {

    public Controller controller; 

    EditPartsWindow(){
        setTitle("Gillig Auto - Edit Existing Parts"); 
        setIconImage(new ImageIcon("Icon//icon.png").getImage()); 
        setLocationRelativeTo(null);
        setAlwaysOnTop(true); 
        setSize(400, 400); 
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
