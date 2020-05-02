package servlets;
import com.google.gson.Gson;
import models.CallBackObject;
import models.Group;
import models.Lecturer;
import models.Student;
import services.GroupService;
import services.LecturerService;
import services.StudentService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CallBackObjectSimpleServlet extends HttpServlet {
    private LecturerService lecturerService = new LecturerService();
    private GroupService groupService = new GroupService();
    private StudentService studentService = new StudentService();
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gson = new String();
        String Name = req.getParameter("Name");
        if (!Name.equals("")) {

           List<Group> groups = groupService.findEqGroups(Name);

           List<Lecturer> lecturers = lecturerService.findEqLecturers(Name);

           List<Student> students = studentService.findEqStudents(Name);

           List <CallBackObject> objects= new ArrayList<CallBackObject>();

           for (Group group:groups){
               objects.add(new CallBackObject(group));
           }
            for (Lecturer lecturer:lecturers){
                objects.add(new CallBackObject(lecturer));
            }
            for (Student student:students){
                objects.add(new CallBackObject(student));
            }
            resp.setContentType("text/html;charset=UTF-8");
            if (objects!=null) {
                gson = new Gson().toJson(objects);
            }
            else {
                gson = "[]";
            }
            resp.getWriter().write(gson);
        }
        else
        {
            gson = "[]";
            resp.getWriter().write(gson);
        }

    }
}
