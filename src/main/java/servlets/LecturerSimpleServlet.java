package servlets;

import com.google.gson.Gson;
import models.Lecturer;
import models.ServletLecturer;
import services.LecturerService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturerSimpleServlet  extends HttpServlet {
    private LecturerService service = new LecturerService();
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String FIO = req.getParameter("FIO");
        String name = req.getRemoteAddr();
        System.out.println(name);
        System.out.println(req.getRemoteUser());
        if (FIO.equals("0") && !FIO.equals("")) {
            List<Lecturer> lecturers = service.findAlllecturers();
            List<ServletLecturer> servletLecturers = new ArrayList<ServletLecturer>();
            for (Lecturer lecturer:lecturers){
                servletLecturers.add(new ServletLecturer(lecturer));
            }
            String gson =  new Gson().toJson(servletLecturers);
            System.out.println(gson);
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write(gson);
        }
        else {
            List <Lecturer> lecturers = service.findEqLecturers(FIO);
            String gson = new String();
            resp.setContentType("text/html;charset=UTF-8");
            if (lecturers!=null) {
                List<ServletLecturer> servletLecturers = new ArrayList<ServletLecturer>();
                for (Lecturer lecturer:lecturers){
                    servletLecturers.add(new ServletLecturer(lecturer));
                }
                gson = new Gson().toJson(servletLecturers);
            }
            else {
                gson = "[]";
            }
            resp.getWriter().write(gson);
        }
    }
}
