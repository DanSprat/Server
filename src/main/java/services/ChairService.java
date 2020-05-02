package services;

import dao.ChairDao;
import models.Chair;

import java.util.List;

public class ChairService {
private ChairDao ChairDao = new ChairDao();
public ChairService(){

}

    public Chair findChair(int id) { return ChairDao.findChairById(id); }

    public void saveChair(Chair chair) { ChairDao.save(chair); }

    public void deleteChair(Chair chair) {
        ChairDao.delete(chair);
    }

    public void updateChair(Chair chair) {
        ChairDao.update(chair);
    }

    public Chair findChairByName(String name) {
        return ChairDao.findChairByName(name);
    }

    public List <Chair> findAllChairs() { return ChairDao.findAllChairs();


    }

}
