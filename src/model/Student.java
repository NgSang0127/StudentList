package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Student implements Serializable {
    private int id;
    private String name;
    private Province birthPlace;
    private LocalDate dob;
    private boolean gender;
    private float score1,score2,score3;

    public Student() {
    }

    public Student(int id, String name, Province birthPlace, LocalDate dob, boolean gender, float score1, float score2,
            float score3) {
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.dob = dob;
        this.gender = gender;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Province birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getDob() {
        return dob;
    }
    public String formatDate() {
        LocalDate dob = this.getDob();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDob = dob.format(formatter);
        return formattedDob;
    }



    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthPlace=" + birthPlace +
                ", dob=" + dob +
                ", gender=" + gender +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }

        if (getId() != student.getId()) {
            return false;
        }
        if (isGender() != student.isGender()) {
            return false;
        }
        if (Float.compare(getScore1(), student.getScore1()) != 0) {
            return false;
        }
        if (Float.compare(getScore2(), student.getScore2()) != 0) {
            return false;
        }
        if (Float.compare(getScore3(), student.getScore3()) != 0) {
            return false;
        }
        if (!getName().equals(student.getName())) {
            return false;
        }
        if (!getBirthPlace().equals(student.getBirthPlace())) {
            return false;
        }
        return getDob().equals(student.getDob());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getBirthPlace().hashCode();
        result = 31 * result + getDob().hashCode();
        result = 31 * result + (isGender() ? 1 : 0);
        result = 31 * result + (getScore1() != 0.0f ? Float.floatToIntBits(getScore1()) : 0);
        result = 31 * result + (getScore2() != 0.0f ? Float.floatToIntBits(getScore2()) : 0);
        result = 31 * result + (getScore3() != 0.0f ? Float.floatToIntBits(getScore3()) : 0);
        return result;
    }
    public float total(){
        return  (this.getScore1()+getScore2()+getScore3());
    }
}
