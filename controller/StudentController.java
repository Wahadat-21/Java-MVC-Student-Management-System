package controller;

import model.Student;
import model.StudentDAO;
import view.StudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {

    private StudentDAO dao;
    private StudentView view;

    public StudentController(StudentDAO dao, StudentView view) {

        this.dao = dao;
        this.view = view;

        view.addButton.addActionListener(new AddStudent());
        view.updateButton.addActionListener(new UpdateStudent());
        view.deleteButton.addActionListener(new DeleteStudent());
        view.displayButton.addActionListener(new DisplayStudents());
    }

    class AddStudent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                int id = Integer.parseInt(view.idField.getText());
                String name = view.nameField.getText();
                String department = view.departmentField.getText();

                Student student =
                        new Student(id, name, department);

                dao.addStudent(student);

                JOptionPane.showMessageDialog(
                        view,
                        "Student Added Successfully"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        view,
                        "Invalid Input"
                );
            }
        }
    }

    class UpdateStudent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                int id =
                        Integer.parseInt(view.idField.getText());

                String name =
                        view.nameField.getText();

                String department =
                        view.departmentField.getText();

                boolean updated =
                        dao.updateStudent(
                                id,
                                name,
                                department
                        );

                if(updated) {

                    JOptionPane.showMessageDialog(
                            view,
                            "Student Updated"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            view,
                            "Student Not Found"
                    );
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        view,
                        "Invalid Input"
                );
            }
        }
    }

    class DeleteStudent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                int id =
                        Integer.parseInt(view.idField.getText());

                boolean deleted =
                        dao.deleteStudent(id);

                if(deleted) {

                    JOptionPane.showMessageDialog(
                            view,
                            "Student Deleted"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            view,
                            "Student Not Found"
                    );
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        view,
                        "Invalid Input"
                );
            }
        }
    }

    class DisplayStudents implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            StringBuilder sb =
                    new StringBuilder();

            for(Student s :
                    dao.getAllStudents()) {

                sb.append(s.toString())
                  .append("\n");
            }

            view.displayArea.setText(
                    sb.toString()
            );
        }
    }
}
