package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Province;
import model.Student;
import view.StudentManagerView;

public class StudentManagerController implements ActionListener {
    private StudentManagerView view;

    public StudentManagerController(StudentManagerView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        JOptionPane.showMessageDialog(this.view,"You just pressed the button: "+command);
        if(command.equals("Insert")){
            this.view.deleteInfo();
            this.view.model.setChoose("Insert");
        }else if(command.equals("Save")){
            try {
                this.view.getDataFromInput();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.view, "ID must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (java.time.format.DateTimeParseException e1) {
                JOptionPane.showMessageDialog(this.view, "Invalid date format. Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.model.setChoose("Save");
        }else if(command.equals("Edit")){
            this.view.displayStudentSelected();
        }else if(command.equals("Delete")){
            this.view.deleteStudent();
        }else if(command.equals("Cancel")){
            this.view.deleteInfo();
        }else if(command.equals("Filter")){
            this.view.filterStudent();
        }else {
            this.view.cancelFilter();
        }
    }
}
