import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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

    private FileGenerator fileGenerator; 

    private DirectoryManager directoryManager; 

    private FileEditor fileEditor;

    AddPartsWindow(){
        //File System Properties
        directoryManager = new DirectoryManager();
        fileGenerator = new FileGenerator();
        fileEditor = new FileEditor(); 

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

        File folder = new File(directoryManager.getDirectory()); 
        File[] files = folder.listFiles();

        for (File file : files){
            if (file.isFile()){
                String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
                getGPartsArrayList.add(name);
            }
        }

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

        //Textfields
        gilligPartNumberTF = new JTextField("Enter A Gillig Part Number");
        gilligPartNumberTF.setPreferredSize(new Dimension(500, 30));
        

        fsiPartNumberTF = new JTextField("Enter FSI Part Number");
        fsiPartNumberTF.setPreferredSize(new Dimension(500, 30));


        quantityTextField = new JTextField("Enter Quantity");
        quantityTextField.setPreferredSize(new Dimension(500, 30));

        //Button
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

    private void makeNewPart(String companyPartName, String fsiPartName, int amountPerBox){
        //Create a new File with Custom File Name
        fileGenerator.generateFile(companyPartName, directoryManager.getDirectory());
        //Add the part to the array list
        getGPartsArrayList.add(gilligPartNumberTF.getText());
        gilligPartNumberModelList.addElement(getGPartsArrayList.get(getGPartsArrayList.size() - 1)); //

        //Edit the File & add the info using File Editor Class
        fileEditor.editNewFile(companyPartName, fsiPartName, amountPerBox);
        //Clear the text fields
        gilligPartNumberTF.setText("");
        fsiPartNumberTF.setText("");
        quantityTextField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.addPartButton) {
            if (quantityTextField.getText().matches("[0-9]+") && quantityTextField.getText().length() > 2) {
                makeNewPart(gilligPartNumberTF.getText(), fsiPartNumberTF.getText(), Integer.parseInt(quantityTextField.getText()));
            }else{
                quantityTextField.setText("ERROR! INTEGERS ONLY NO FLOATING POINTS");
            }
            
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
