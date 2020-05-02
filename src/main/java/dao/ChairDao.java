package dao;

import models.Chair;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ChairDao {

    public Chair findChairById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Chair.class, id);
    }

    public Chair findChairByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Chair.class);
        userCriteria.add(Restrictions.eq("Name",name));
        Chair chair = (Chair) userCriteria.uniqueResult();
        session.close();
        return chair;
    }


    public List<Chair> findAllChairs(){
        List<Chair> groups = (List<Chair>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Chair").list();
        return groups;
    }
    public void save(Chair chair)  {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(chair);
        tx1.commit();
        session.close();
    }
    public void update(Chair  chair) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(chair);
        tx1.commit();
        session.close();
    }
    public void delete(Chair chair) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(chair);
        tx1.commit();
        session.close();
    }
}
