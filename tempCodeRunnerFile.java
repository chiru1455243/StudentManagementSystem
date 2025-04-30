import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();
                StudentDAO.addStudent(name, age, course);
                outputArea.setText("✅ Student Added Successfully!");
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                StudentDAO.getAllStudents();
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(courseLabel);
        frame.add(courseField);
        frame.add(addButton);
        frame.add(viewButton);
        frame.add(outputArea);

        frame.setVisible(true);
    }
}
