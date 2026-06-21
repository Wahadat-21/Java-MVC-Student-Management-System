package view;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {

    public JTextField idField;
    public JTextField nameField;
    public JTextField departmentField;

    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton displayButton;

    public JTextArea displayArea;

    public StudentView() {

        setTitle("Student Management MVC");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));

        panel.add(new JLabel("ID"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Department"));
        departmentField = new JTextField();
        panel.add(departmentField);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        displayButton = new JButton("Display");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(displayButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }
}
