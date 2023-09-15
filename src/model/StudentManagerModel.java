package model;

import java.util.ArrayList;

public class StudentManagerModel {
    private ArrayList<Student>listStudent;
    private String choose;

    public StudentManagerModel() {
        this.listStudent = new ArrayList<Student>();
        this.choose="";
    }

    public StudentManagerModel(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
    public void insertStudent(Student student) {
        this.listStudent.add(student);
    }
    public void deleteStudent(Student student) {
        this.listStudent.remove(student);
    }
    public void updateStudent(Student student) {
        this.listStudent.remove(student);
        this.listStudent.add(student);
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public boolean checkExists(Student student) {
        for(Student s:listStudent){
            if(s.getId()==student.getId()){
                return true;
            }
        }
            return false;
    }
}
