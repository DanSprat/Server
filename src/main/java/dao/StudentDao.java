package dao;

import models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StudentDao {
    public Student findStudentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }
    public List<Student> findAllEq(String string){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Student.class);
        userCriteria.add(Restrictions.ilike("Name",string+"%")).list();
        List<Student> students = (List<Student>) userCriteria.list();
        session.close();
        return students;
    }

    public List<Student> findStudentByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Student.class);
        userCriteria.add(Restrictions.eq("Name",name)).list();
        List<Student> students = userCriteria.list();
        session.close();
        return students;
    }


    public List<Student> findAllStudents(){
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }
    public void save(Student student)  {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }
    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }
}
