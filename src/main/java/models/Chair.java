package models;

import unnModels.unnChair;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="unnchairs")
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String Name;

    @ManyToMany(mappedBy="chairs")
    //@JoinTable(name="unn_lecturer_chair",joinColumns = {@JoinColumn(name="chair_id")},inverseJoinColumns = {@JoinColumn(name="lecturer_id")})
    List<Lecturer> Lecturers = new ArrayList<Lecturer>();
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void AddLecturer(Lecturer lecturer)
    {
        Lecturers.add(lecturer);
    }


    public Chair(String Name){
        this.Name=Name;
        this.Lecturers = new ArrayList<Lecturer>();
    }
    public Chair(){

    }

    public Chair(unnChair unnChair){
        this.Name = unnChair.getName();
    }
}
