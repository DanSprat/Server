package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class ServletLecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name="unnid")
    private  int unnId;

     private List<String> chairs =new ArrayList<String>();

    public ServletLecturer(Lecturer lecturer){
        this.id=lecturer.getId();
        this.Name = lecturer.getName();
        this.unnId=lecturer.getUnnId();
        for (Chair chair:lecturer.getChairs()){
            this.chairs.add(chair.getName());
        }
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

    public List<String> getChairs() {
        return chairs;
    }

    public void setChairs(List<String> chairs) {
        this.chairs = chairs;
    }
}
