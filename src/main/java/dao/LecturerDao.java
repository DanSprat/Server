package dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;
import models.Lecturer;
public class LecturerDao {

    public Lecturer findLecturerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Lecturer.class, id);
    }
    public List<Lecturer> findAllEq(String string){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Lecturer.class);
        userCriteria.add(Restrictions.ilike("Name",string+"%")).list();
        List<Lecturer> lecturers = (List<Lecturer>) userCriteria.list();
        session.close();
        return lecturers;
    }

    public List<Lecturer> findLecturerByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Lecturer.class);
        userCriteria.add(Restrictions.eq("Name",name)).list();
        List<Lecturer> lecturers = userCriteria.list();
        session.close();
        return lecturers;
    }


    public List<Lecturer> findAllLecturers(){
        List<Lecturer> groups = (List<Lecturer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Lecturer").list();
        return groups;
    }
    public void save(Lecturer lecturer)  {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(lecturer);
        tx1.commit();
        session.close();
    }
    public void update(Lecturer lecturer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(lecturer);
        tx1.commit();
        session.close();
    }
    public void delete(Lecturer lecturer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(lecturer);
        tx1.commit();
        session.close();
    }
}
