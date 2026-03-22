package Studentinfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Student {

    // Simple storage
    ArrayList<String> students = new ArrayList<>();

    public Student() {
        JFrame frame = new JFrame("Student System");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input fields
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        JTextArea display = new JTextArea(10, 30);
        display.setEditable(false);

        // Buttons
        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("View");
        JButton deleteBtn = new JButton("Delete");

        // Add components
        frame.add(new JLabel("ID:"));
        frame.add(idField);

        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.add(new JScrollPane(display));

        // ADD
        addBtn.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();

            students.add(id + " - " + name);
            display.setText("Student Added ✅");
        });

        // VIEW
        viewBtn.addActionListener(e -> {
            String data = "";
            for (String s : students) {
                data += s + "\n";
            }
            display.setText(data);
        });

        // DELETE (by ID)
        deleteBtn.addActionListener(e -> {
            String id = idField.getText();
            boolean found = false;

            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).startsWith(id + " -")) {
                    students.remove(i);
                    found = true;
                    break;
                }
            }

            if (found)
                display.setText("Deleted ");
            else
                display.setText("Not Found ");
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Student();
    }
}
