package models;
import unnModels.unnLecturer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="unnlecturers")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name="unnid")
    private  int unnId;

    @ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
    @JoinTable(name = "unn_lecturer_chair", joinColumns = {@JoinColumn(name = "lecturer_id")}, inverseJoinColumns = {@JoinColumn(name = "chair_id")})
    private List<Chair> chairs = new ArrayList<Chair>();

    public void addChair(Chair chair)
    {
        chairs.add(chair);
        chair.AddLecturer(this);
    }

    public Lecturer() {
    }

    public Lecturer(String Name,int unnId)
    {
        this.Name=Name;
        this.unnId= unnId;
        this.chairs = new ArrayList<Chair>();
    }

    public Lecturer(unnLecturer unnLecturer)
    {
        this.Name = unnLecturer.getFio();
        this.unnId = unnLecturer.getLecturerOid();
    }

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
    public int getUnnId() {
        return unnId;
    }
    public void setUnnId(int unnId) {
        this.unnId = unnId;
    }
    public List<Chair> getChairs() {
        return chairs;
    }
    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }
}
