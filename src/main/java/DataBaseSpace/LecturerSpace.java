package DataBaseSpace;

import interfaces.JsonPlaceHolderApi;
import models.Chair;
import models.Group;
import models.Lecturer;
import retrofit.*;
import services.ChairService;
import services.LecturerService;
import unnModels.*;

import java.util.ArrayList;
import java.util.List;

public class LecturerSpace {
    private List<Lecturer> Translate (List<unnLecturer> unnLecturers){
        List<Lecturer> Lecturers= new ArrayList<Lecturer>();
        for (unnLecturer unnLecturer:unnLecturers)
        {
           // Lecturers.add(new Lecturer(unnLecturer));
        }
        return Lecturers;
    }
    final String BASE_URL = "https://journal.unn.ru/";
    public void create() throws RuntimeException {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
            Call<List<unnLecturer>> call = jsonPlaceHolderApi.getlecturers(0);
           call.enqueue(new Callback<List<unnLecturer>>() {
               @Override
               public void onResponse(Response<List<unnLecturer>> response, Retrofit retrofit) {
                   if (!response.isSuccess()) {
                       System.out.println("Code:" + response.code());
                       return;
                   }
                   ChairSpace chairSpace = new ChairSpace();
                   List <unnLecturer> unnlecturers=response.body();

                   for (int i=0;i<unnlecturers.size();i++)
                   {
                       ChairService chairService = new ChairService();
                       LecturerService lecturerService = new LecturerService();
                       List<Lecturer> lecturers = lecturerService.findLecturerByName(unnlecturers.get(i).getFio());
                       if (lecturers.size()==0)
                       {
                           Lecturer newlecturer = new Lecturer(unnlecturers.get(i));
                           lecturerService.saveLecturer(newlecturer);
                          Chair chair = chairService.findChairByName(unnlecturers.get(i).getChair());
                          if (chair!=null){
                          newlecturer.addChair(chair);
                          chair.AddLecturer(newlecturer);
                          }
                          lecturerService.updateLecturer(newlecturer);
                       }
                       else {
                           boolean AlreadyIn=false;
                           for (int j=0;j<lecturers.size();j++){
                               if (unnlecturers.get(i).getLecturerOid() == lecturers.get(j).getUnnId()){
                                   Chair chair = chairService.findChairByName(unnlecturers.get(i).getChair());
                                   if (chair!=null)
                                   lecturers.get(i).addChair(chair);
                                   chair.AddLecturer(lecturers.get(i));
                                   lecturerService.updateLecturer(lecturers.get(i));
                                   AlreadyIn = true;
                                   break;
                               }
                           }
                           if(!AlreadyIn){
                               Lecturer newlecturer = new Lecturer(unnlecturers.get(i));
                               Chair chair = chairService.findChairByName(unnlecturers.get(i).getChair());
                               chair.AddLecturer(newlecturer);
                               newlecturer.addChair(chair);
                               lecturerService.saveLecturer(newlecturer);
                           }
                       }
                   }
               }

               @Override
               public void onFailure(Throwable throwable) {
                   System.out.println(throwable.getMessage());
               }
           });
        }
        catch (RuntimeException ex)
        {
            ex.getMessage();
        }
    }
}
