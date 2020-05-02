package models;

import java.util.ArrayList;
import java.util.List;

public class CallBackObject {

private int type;

private String Name;

private int unnid;

private List<String> info=new ArrayList<String>();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUnnid() {
        return unnid;
    }

    public void setUnnid(int unnid) {
        this.unnid = unnid;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public CallBackObject(ServletLecturer servletLecturer) {
        this.Name = servletLecturer.getName();
        this.unnid = servletLecturer.getUnnId();
        this.info = servletLecturer.getChairs();
    }

    public  CallBackObject (Group group){
        type = 3;
        this.Name = group.getgName();
        this.unnid=group.getUnnid();
        this.info.add(group.getInfo());
    }

    public  CallBackObject (Lecturer lecturer){
        type =1;
        this.Name = lecturer.getName();
        for (Chair chair:lecturer.getChairs()){
            this.info.add(chair.getName());
        }
        this.unnid = lecturer.getUnnId();
    }
   public CallBackObject (Student student){
        type = 0;
        this.Name = student.getName();
        this.unnid = student.getUnnid();
        this.info.add(student.getGroup());
   }
   public CallBackObject (){
        info = new ArrayList<String>();
   }
}
