import DataBaseSpace.ChairSpace;
import DataBaseSpace.GroupSpace;
import DataBaseSpace.LecturerSpace;
import DataBaseSpace.StudentSpace;
import com.google.gson.Gson;
import models.*;
import services.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
         //GroupSpace groupSpace = new GroupSpace();
        // groupSpace.create();
        //ChairSpace chairSpace = new ChairSpace();
       // chairSpace.create();
        LecturerSpace lecturerSpace = new LecturerSpace();
        lecturerSpace.create();
        // LecturerService service = new LecturerService();
        // List<Lecturer> lecturers = service.findAlllecturers();
        // String gson =  new Gson().toJson(lecturers);
        // System.out.println(gson);
         //StudentSpace studentSpace = new StudentSpace();
        // studentSpace.create();
       //  LecturerService lecturerService = new LecturerService();
        //List<CallBackObject> objects = new ArrayList<CallBackObject>();
    }
}