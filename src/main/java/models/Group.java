package models;
import unnModels.unnGroup;
import javax.persistence.*;

@Entity
@Table (name="unnGroups")

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name= "gName")
    private String gName;

    @Column(name="info")
    private String info;

    @Column(name="unnid")
    private int unnid;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getUnnid() {
        return unnid;
    }

    public void setUnnid(int unnid) {
        this.unnid = unnid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group(){
    }

    public Group (unnGroup group) {
     gName =  group.getNumber();
     unnid = group.getGroupOid();
    if (group.getCourse()==1 || group.getCourse()==4 ||group.getCourse()==5)
        {
            info = group.getFaculty()+" "+group.getCourse()+"-ый курс";
        } else if ( group.getCourse()==2|| group.getCourse()==6) {
        info = group.getFaculty()+" "+group.getCourse()+"-ой курс";
    } else {
        info = group.getFaculty()+" "+group.getCourse()+"-ий курс";
    }

    }

    public Group(String name){
        this.gName=name;
    }

    public void setgName(String name){
        this.gName=name;
    }

    public String getgName() {
        return gName;
    }

    public int getId() { return id; }
}

