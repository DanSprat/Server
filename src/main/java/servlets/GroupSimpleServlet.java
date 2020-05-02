package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import models.Group;
import services.GroupService;
public class GroupSimpleServlet extends HttpServlet {

    private GroupService service = new GroupService();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getRemoteAddr();
        System.out.println(name);
        String gName = req.getParameter("gName");
           if (gName.equals("0") && !gName.equals("")) {
               List<Group> groups = service.findAllGroups();
               String gson =  new Gson().toJson(groups);
               System.out.println(gson);
               resp.setContentType("text/html;charset=UTF-8");
               resp.getWriter().write(gson);
       }
        else {

            List <Group> groups = service.findEqGroups(gName);
            String gson = new String();
            resp.setContentType("text/html;charset=UTF-8");
            if (groups!=null) {
                 gson = new Gson().toJson(groups);
            }
            else {
                  gson = "[]";
            }
                resp.getWriter().write(gson);
        }

    }
}
