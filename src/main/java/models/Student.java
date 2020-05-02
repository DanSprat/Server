package models;

import unnModels.unnStudent;

import javax.persistence.*;

@Entity
@Table(name = "unnStudents" )
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "Name")
    private String Name;

    @Column(name="grName")
    private String Group;

    @Column(name="unnid")
    private int unnid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public int getUnnid() {
        return unnid;
    }

    public void setUnnid(int unnid) {
        this.unnid = unnid;
    }

    public Student(unnStudent unnStudent){
        this.Name = unnStudent.getFio();
        this.unnid = unnStudent.getStudentOid();
    }
    public Student(){

    }
}
