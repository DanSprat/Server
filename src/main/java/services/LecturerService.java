package services;

import dao.LecturerDao;
import models.Lecturer;

import java.util.List;

public class LecturerService {
    private LecturerDao LecturerDao = new LecturerDao();
    public LecturerService() {
    }
    public Lecturer findLecturer(int id) {
        return LecturerDao.findLecturerById(id);
    }

    public void saveLecturer(Lecturer lecturer) { LecturerDao.save(lecturer); }

    public void deleteLecturer(Lecturer lecturer) {
        LecturerDao.delete(lecturer);
    }

    public void updateLecturer(Lecturer lecturer) {
        LecturerDao.update(lecturer);
    }

    public List<Lecturer> findLecturerByName(String name) {
        return LecturerDao.findLecturerByName(name);
    }

    public List <Lecturer> findAlllecturers() {
        return LecturerDao.findAllLecturers();
    }

    public List<Lecturer> findEqLecturers(String string) {return  LecturerDao.findAllEq(string);}
}
