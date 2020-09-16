package DataBaseSpace;

import interfaces.JsonPlaceHolderApi;
import models.Chair;
import retrofit.*;
import services.ChairService;
import unnModels.unnChair;
import unnModels.unnGroup;

import java.util.ArrayList;
import java.util.List;

public class ChairSpace {
    private List<Chair> Translate (List<unnChair> unnChairs){
        List<Chair> chairs= new ArrayList<Chair>();
        for (unnChair unnChair:unnChairs)
        {
            chairs.add(new Chair(unnChair));
        }
        return chairs;
    }
    final String BASE_URL = "https://journal.unn.ru/";
        public void create() throws RuntimeException {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
                Call<List<unnChair>> call = jsonPlaceHolderApi.getchairs(0);
                call.enqueue(new Callback<List<unnChair>>() {
                    @Override
                    public void onResponse(Response<List<unnChair>> response, Retrofit retrofit) {
                        if (!response.isSuccess())
                        {
                            System.out.println("Code:" + response.code());
                            return;
                        }
                         List<unnChair> unnChairs = response.body();
                         List<Chair> Chairs = Translate(unnChairs);
                        for (int i = 1; i < Chairs.size(); i++) {
                            ChairService chairService = new ChairService();
                             Chair chair = chairService.findChairByName(Chairs.get(i).getName());
                            if (chair==null)
                                chairService.saveChair(Chairs.get(i));
                        }
                    }
                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                });
            }
            catch (RuntimeException ex)
            {
                ex.getMessage();
            }
        }
    }

