package DataBaseSpace;
import interfaces.JsonPlaceHolderApi;
import models.*;
import retrofit.*;
import services.GroupService;
import unnModels.*;
import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class GroupSpace  {
    private List<Group> Translate (List<unnGroup> unnGroups){
        List<Group> groups= new ArrayList<Group>();
        for (unnGroup unnGroup:unnGroups)
        {
            groups.add(new Group(unnGroup));
        }
        return groups;
    }
    final String BASE_URL = "https://journal.unn.ru/";
    public void create() throws RuntimeException {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
            Call<List<unnGroup>> call = jsonPlaceHolderApi.getgroups(0);
            call.enqueue(new Callback<List<unnGroup>>() {
                @Override
                public void onResponse(Response<List<unnGroup>> response, Retrofit retrofit) {
                    if (!response.isSuccess()) {
                        System.out.println("Code:" + response.code());
                        return;
                    }
                    System.out.println("im here");
                    List<unnGroup> unnGroups = response.body();
                    List<Group> Groups = Translate(unnGroups);
                    for (int i = 1; i < Groups.size(); i++) {

                        GroupService groupService = new GroupService();
                        //Group group= groupService.findCGroupByName(Groups.get(i).getgName());
                        List <Group> groups = groupService.findCGroupByName(Groups.get(i).getgName());
                        if (groups.get(0)==null)
                        groupService.saveGroup(Groups.get(i));
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
