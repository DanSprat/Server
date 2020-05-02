package interfaces;
import com.google.gson.internal.Streams;
import models.*;
import java.util.List;
import retrofit.Call;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import unnModels.*;

public interface JsonPlaceHolderApi {
    @GET("schedule.php")
    Call<List<unnGroup>> getgroups(@Query(value = "groups?facultyOid") int facultyOid);
    @GET("schedule.php")
    Call<List<unnLecturer>> getlecturers(@Query(value = "lecturers?chairOid") int facultyOid);
    @GET("schedule.php")
    Call<List<unnChair>> getchairs(@Query(value = "chairs?facultyOid") int facultyOid);
    @GET("schedule.php?/streams")
    Call <List<unnStream>> getstreams();
    @GET("schedule.php")
    Response<List<unnGroup>> getgroupss(@Query(value = "groups?facultyOid") int facultyOid);
    @GET("schedule.php")
    Call<List<unnStudent>> getstudents(@Query(value ="staffofgroup?groupOid") int groupOid );

}


