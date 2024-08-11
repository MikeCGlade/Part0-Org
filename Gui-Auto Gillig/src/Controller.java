
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {

    public MainJFrame mainFrame; 

    public AddPartsWindow addPartsWindow;
    
    public EditPartsWindow editPartsWindow;

    public CSVWindow csvWindow;

    public Controller (){
        mainFrame = new MainJFrame();
        addActionListeners();
    }

    private void addActionListeners(){
        mainFrame.button1.addActionListener(this);
        mainFrame.button2.addActionListener(this);
        mainFrame.button3.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.button1){
            addPartsWindow = new AddPartsWindow(); 
        }

        if (e.getSource() == mainFrame.button2){
            editPartsWindow = new EditPartsWindow();
        }

        if (e.getSource() == mainFrame.button3){
            csvWindow = new CSVWindow(); 
        }
    }

}
