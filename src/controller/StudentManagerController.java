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
        if(command.equals("Insert")){
            this.view.deleteInfo();
            this.view.model.setChoose("Insert");
        }else if(command.equals("Save data")){
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
        }else if (command.equals("Cancel Filter")){
            this.view.cancelFilter();
        }else if(command.equals("About me")){
            this.view.displayAbout();
        }else if(command.equals("Exit")){
            this.view.exitProgram();
        }else if(command.equals("Save file")){
            this.view.saveFile();
        }else if(command.equals("Open")){
            this.view.openFile();
        }
    }
}
