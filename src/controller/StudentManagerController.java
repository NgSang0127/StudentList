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
                int id=Integer.valueOf(this.view.jTextField_id.getText());
                String name=this.view.jTextField_name.getText();
                int birthPlace=this.view.jComboBox_birth.getSelectedIndex();
                Province province=Province.getProvinceById(birthPlace-1);//do có phần rỗng ko hiện
                String dateText = this.view.jTextField_date.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dob = LocalDate.parse(dateText, formatter);
                boolean gender =true;
                if(this.view.jRadioButton_male.isSelected()){
                    gender=true;
                }else if(this.view.jRadioButton_female.isSelected()){
                    gender=false;
                }
                Float score1=Float.valueOf(this.view.jTextField_score1.getText());
                Float score2=Float.valueOf(this.view.jTextField_score2.getText());
                Float score3=Float.valueOf(this.view.jTextField_score3.getText());

                Student student=new Student(id,name,province,dob,gender,score1,score2,score3);
                    this.view.insertIntoTable(student);
                    this.view.jTextField_total.setText(this.view.setTotal(student));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.view, "ID must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (java.time.format.DateTimeParseException e1) {
                JOptionPane.showMessageDialog(this.view, "Invalid date format. Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.model.setChoose("Save");
        }else if(command.equals("Edit")){
            this.view.displayStudentSelected();

        }
    }
}
