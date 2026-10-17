import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UI {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField idField1;
    private JTextField nameField1;
    private JTextField emailField1;
    private JButton ADDButton;
    private JTable table1;
    private JComboBox yearBox1;
    private JComboBox catBox1;
    private JTextField idField2;
    private JTextField nameField2;
    private JComboBox yearBox2;
    private JTextField emailField2;
    private JTable table2;
    private JButton SEARCHButton;
    private JButton EDITButton;
    private JComboBox catBox2;
    private JTextField idField3;
    private JButton DELETEButton;
    private JTable table3;
    private JPanel ADD;
    private JLabel iLabel;
    private JLabel nLabel;
    private JLabel yLabel;
    private JLabel emLabel;
    private JLabel catLabel;
    private Database database;

    public UI() {
        database = new Database();
        setVisibility(false);
        setComboBox();
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idField1.getText().trim().isEmpty() == true ||
                        nameField1.getText().trim().isEmpty() == true ||
                        emailField1.getText().trim().isEmpty() == true){
                    JOptionPane.showMessageDialog(mainPanel, "PLEASE FILL THE EMPTY FIELD");
                }
                else if (findRowById(table1,idField1.getText(), 0, false) == true){
                    JOptionPane.showMessageDialog(mainPanel, "ID BEEN USED, PLEASE USE ANOTHER ID");
                }else{

                    int year = Integer.parseInt(yearBox1.getSelectedItem().toString());
                    String category = catBox1.getSelectedItem().toString();
                    String query = "INSERT INTO persontable VALUES ('" + idField1.getText() + "', '" + nameField1.getText() + "', '" + year + "', '" + emailField1.getText() +"', '" +category +"')";
                    database.Changes(query);
                    setTable();
                    clear();
                }

            }
        });
        setTable();
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(findRowById(table1, idField2.getText(), 0, true) == true){
                    setVisibility(true);

                }
                else{
                    JOptionPane.showMessageDialog(mainPanel, "ID DOESNT EXIST");
                }
            }
        });
        EDITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idField2.getText().trim().isEmpty()||
                        nameField2.getText().trim().isEmpty() ||
                        emailField2.getText().trim().isEmpty() ){
                    JOptionPane.showMessageDialog(mainPanel, "PLEASE FILL THE EMPTY FIELD");
                }else {
                    int year = Integer.parseInt(yearBox2.getSelectedItem().toString());
                    String category = catBox2.getSelectedItem().toString();
                    String query = "UPDATE persontable SET name = '" + nameField2.getText() + "', year = '" + year + "', email = '" + emailField2.getText() + "', category = '" + category + "' WHERE id = '" + idField2.getText() + "'";
                    database.Changes(query);
                    JOptionPane.showMessageDialog(mainPanel, "Element with ID :" + idField2.getText() +" is successfully changed");
                    setVisibility(false);
                    idField2.setText("");
                    setTable();
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idField3.getText().trim().isEmpty() == true){
                    JOptionPane.showMessageDialog(mainPanel, "PLEASE FILL THE ID FIELD");
                }
                else if(findRowById(table3, idField3.getText(), 0, false) == false){
                    JOptionPane.showMessageDialog(mainPanel, "ID DOESNT EXIST");
                }
                else {
                    int confirm = JOptionPane.showConfirmDialog(mainPanel, "Are you sure to delete this data?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0) {
                        String query = "DELETE FROM persontable WHERE id='" + idField3.getText() + "'";
                        database.Changes(query);
                    }
                    setTable();
                }
            }
        });
        table3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int select = table3.getSelectedRow();
                idField3.setText(table3.getValueAt(select, 0).toString());

            }
        });

        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int select = table2.getSelectedRow();
                setVisibility(true);
                idField2.setText(table2.getValueAt(select, 0).toString());
                nameField2.setText(table2.getValueAt(select, 1).toString());
                yearBox2.setSelectedItem(table2.getValueAt(select, 2));
                emailField2.setText(table2.getValueAt(select, 3).toString());
                catBox2.setSelectedItem(table2.getValueAt(select, 4));
            }
        });
    }
    public void setComboBox() {
        if (yearBox1 == null) {
            yearBox1 = new JComboBox<>();
        } else {
            yearBox1.removeAllItems();
        }

        if (yearBox2 == null) {
            yearBox2 = new JComboBox<>();
        } else {
            yearBox2.removeAllItems();
        }

        if (catBox1 == null) {
            catBox1 = new JComboBox<>();
        } else {
            catBox1.removeAllItems();
        }

        if (catBox2 == null) {
            catBox2 = new JComboBox<>();
        } else {
            catBox2.removeAllItems();
        }

        String[] category = {"LULUS", "TIDAK LULUS", "MENGUNDURKAN DIRI", "DIKELUARKAN"};
        catBox1.setModel(new DefaultComboBoxModel<>(category));
        catBox2.setModel(new DefaultComboBoxModel<>(category));
        for (int i = 1900; i <= 2026; i++) {
            yearBox1.addItem(i);
        }
        for (int i = 1900; i <= 2026; i++) {
            yearBox2.addItem(i);
        }
        yearBox1.setSelectedItem(2026);
        yearBox2.setSelectedItem(2026);
    }
    public boolean findRowById(JTable model, Object targetId, int idColumnIndex, boolean tableVisRelated) {
        if (model == null || targetId == null) {
            return false;
        }

        int rowCount = model.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            Object cellValue = model.getValueAt(row, idColumnIndex);

            if (cellValue != null && cellValue.toString().equals(targetId.toString())) {
                if(tableVisRelated == true ) {
                    nameField2.setText(model.getValueAt(row, 1).toString());
                    yearBox2.setSelectedItem(model.getValueAt(row, 2));
                    emailField2.setText(model.getValueAt(row, 3).toString());
                    catBox2.setSelectedItem(model.getValueAt(row, 4));
                }
                return true; // ID found at this row index
            }
        }

        return false; // ID does not exist in the table
    }


    public void setVisibility(boolean vis){
        nameField2.setVisible(vis);
        yearBox2.setVisible(vis);
        emailField2.setVisible(vis);
        catBox2.setVisible(vis);
        EDITButton.setVisible(vis);
        nLabel.setVisible(vis);
        yLabel.setVisible(vis);
        emLabel.setVisible(vis);
        catLabel.setVisible(vis);
    }
    public void clear(){
        nameField1.setText("");
        idField1.setText("");
        emailField1.setText("");
    }
    public void setTable(){
        ResultSet rs = database.selectQuery("SELECT * FROM persontable");
        try {
            String[] Header = {"ID", "NAME", "YEAR", "EMAIL", "CATEGORY"};
            DefaultTableModel model = new DefaultTableModel(Header, 0);
            while(rs.next()){
                Object[] row ={rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)};
                model.addRow(row);
            }
            table1.setModel(model);
            table2.setModel(model);
            table3.setModel(model);
            table1.getTableHeader().setReorderingAllowed(false);
            table2.getTableHeader().setReorderingAllowed(false);
            table3.getTableHeader().setReorderingAllowed(false);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("LISTING");
        UI uii = new UI();
        frame.setContentPane(uii.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
