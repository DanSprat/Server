package services;

import dao.StudentDao;
import models.Student;

import java.util.List;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public Student findStudent(int id) { return studentDao.findStudentById(id); }

    public void saveStudent(Student student) { studentDao.save(student); }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) { studentDao.update(student); }

    public List<Student> findStudentByName(String name) { return studentDao.findStudentByName(name); }

    public List <Student> findAllStudents() { return studentDao.findAllStudents(); }

    public List<Student> findEqStudents(String string) {return  studentDao.findAllEq(string);}
}
