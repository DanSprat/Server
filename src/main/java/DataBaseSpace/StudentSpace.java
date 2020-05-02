package DataBaseSpace;

import dao.StudentDao;
import interfaces.JsonPlaceHolderApi;
import models.Group;
import models.Student;
import retrofit.*;
import services.StudentService;
import unnModels.unnGroup;
import unnModels.unnStudent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentSpace {
    ///////////////////////////////////////////////////////////

    private List<Student> Translate (List<unnStudent> unnStudents){
        List<Student> students= new ArrayList<Student>();
        for (unnStudent unnStudent:unnStudents)
        {
            students.add(new Student(unnStudent));
        }
        return students;
    }

    ////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////
    final String BASE_URL = "https://journal.unn.ru/";
    //////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////
    private List<unnGroup> getgroups() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
            Call<List<unnGroup>> response = jsonPlaceHolderApi.getgroups(0);
            Response<List<unnGroup>> groups = response.execute();
            List<unnGroup> grs =groups.body();
            return grs;
        } catch (RuntimeException | IOException ex) {
            ex.getMessage();
        }
        return null;
    }
    public void create() throws RuntimeException {
        List<unnGroup>  groups = getgroups();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        try {

            for (int i = 0; i < groups.size(); i++) {
              Call<List<unnStudent>> call = jsonPlaceHolderApi.getstudents(groups.get(i).getGroupOid());
              String name =groups.get(i).getNumber();
              call.enqueue(new Callback<List<unnStudent>>() {
                  @Override
                  public void onResponse(Response<List<unnStudent>> response, Retrofit retrofit) {
                      StudentService studentService = new StudentService();
                      if (!response.isSuccess()) {
                          System.out.println("Code:" + response.code());
                          return;
                      }
                      List<unnStudent> unnstudents = response.body();
                      if (unnstudents.size()!=0) {
                          List<Student> students = Translate(unnstudents);
                          for (int j = 0; j < students.size(); j++) {
                              final String gName = name;
                              students.get(j).setGroup(gName);
                              studentService.saveStudent(students.get(j));
                          }
                      }
                  }
                  @Override
                  public void onFailure(Throwable throwable) {

                  }
              });
            }
        } catch (RuntimeException ex){
            ex.getMessage();
        }
    }
}
