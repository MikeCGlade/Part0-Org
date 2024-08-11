
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public final class AddPartsWindow extends JFrame implements ActionListener, KeyListener {

    public Controller controller; 

    private JPanel panel;

    private JButton addPartButton; 
    private JButton removePartButton; 

    private JLabel gilligPartNumberLabel; 
    private JLabel fsiPartNumberLabel;
    private JLabel quantityPerBoxLabel;  

    private JTextField gilligPartNumberTF;
    private JTextField fsiPartNumberTF;
    private JTextField quantityTextField; 
    public JTextField removeSearchTextField; 

    private JList<String> gilligPartsJList;
    private JScrollPane scrollPane;

    public ArrayList<String> getGPartsArrayList; 

    public String[] gilligPartNumbers; 

    private DefaultListModel<String> gilligPartNumberModelList; 

    AddPartsWindow(){
        //Defaults
        setTitle("Gillig Auto - Add New Parts"); 
        setIconImage(new ImageIcon("Icon//icon.png").getImage()); 
        setLocationRelativeTo(null);
        setAlwaysOnTop(true); 
        setSize(500, 500); 
        setVisible(true); 
        setResizable(false);

        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 20)); 

        //Debug

        gilligPartNumberModelList = new DefaultListModel<>();

        getGPartsArrayList = new ArrayList<>(); 

        getGPartsArrayList.add("GILLIG12345");
        getGPartsArrayList.add("GILLIG12345678");
        getGPartsArrayList.add("GILLIG12345678678");
        getGPartsArrayList.add("GILLIG12345sdfds678678");
        getGPartsArrayList.add("GILLIG12345sdfdssdfsd678678");
        getGPartsArrayList.add("GILLIG12345sdfds6sdfdf78678");
        getGPartsArrayList.add("GILLIG12345sdfds6sdsdfhgjfdf78678");
        getGPartsArrayList.add("GILLIG12345sdfds6sdsdfhgjfdfsdfd78678");
        getGPartsArrayList.add("GILLIG12345sdfds6sdsdfhgjfdf78sdfsdssdd678");
        getGPartsArrayList.add("GILLIG12345sdfds6sdsdfhgjfdfsdfdsfsdfsdfsdfsdfsdf78678");
        getGPartsArrayList.add("HSDJFSJDHF");

        for (int i = 0; i < getGPartsArrayList.size(); i++){
            gilligPartNumberModelList.addElement(getGPartsArrayList.get(i));
        }

        //Add components
        instantiateComponents();
        addComponents();

        pack();

    }

    private void searchFilter(String searchTerm){
        DefaultListModel<String> filteredModel = new DefaultListModel<>();
        for (int i = 0; i < getGPartsArrayList.size(); i++){
            if (gilligPartNumberModelList.get(i).toLowerCase().contains(searchTerm.toLowerCase())){
                filteredModel.addElement(gilligPartNumberModelList.get(i));
            }
        }

        //gilligPartNumberModelList = filteredModel; 
        if (removeSearchTextField.getText() == ""){
            filteredModel.clear();
            gilligPartsJList.setModel(gilligPartNumberModelList);
        }else{
            gilligPartsJList.setModel(filteredModel);
        }
    }

    private void instantiateComponents(){
        panel = new JPanel(); 
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 20));

        gilligPartNumberLabel = new JLabel("Gillig Part #:");
        fsiPartNumberLabel = new JLabel("FSI Part #:");
        quantityPerBoxLabel = new JLabel("Quantity per Box:");

        gilligPartNumberTF = new JTextField("Enter A Gillig Part Number");
        gilligPartNumberTF.setPreferredSize(new Dimension(500, 30));
        fsiPartNumberTF = new JTextField("Enter FSI Part Number");
        fsiPartNumberTF.setPreferredSize(new Dimension(500, 30));
        quantityTextField = new JTextField("Enter Quantity");
        quantityTextField.setPreferredSize(new Dimension(500, 30));

        addPartButton = new JButton("Add Part");
        addPartButton.addActionListener(this);

        //List Settings
        gilligPartsJList = new JList<>(gilligPartNumberModelList);
        gilligPartsJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        //Scroll Settings
        scrollPane = new JScrollPane(gilligPartsJList);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        //Search Field
        removeSearchTextField = new JTextField("Search Parts");
        removeSearchTextField.setPreferredSize(new Dimension(500, 30));
        removeSearchTextField.addKeyListener(this);

        removePartButton = new JButton("Remove Part");
        removePartButton.addActionListener(this);
    }

    private void addComponents(){
        add(panel); 

        panel.add(gilligPartNumberLabel);
        panel.add(gilligPartNumberTF); 

        panel.add(fsiPartNumberLabel);
        panel.add(fsiPartNumberTF); 

        panel.add(quantityPerBoxLabel);
        panel.add(quantityTextField); 

        panel.add(addPartButton); 

        panel.add(scrollPane);

        panel.add(removeSearchTextField);

        panel.add(removePartButton); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addPartButton) {
            System.out.println("Added Part Debug");
        }

        if (e.getSource() == this.removePartButton) {
            System.out.println("Removed Part Debug");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        searchFilter(removeSearchTextField.getText());
        //System.out.println(e.getKeyCode());
    }

}
