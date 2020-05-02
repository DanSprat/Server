package dao;
import models.Group;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
public class GroupDao {
    public Group findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }
    public List<Group> findAllEq(String string){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Group.class);
        userCriteria.add(Restrictions.ilike("gName",string+"%")).list();
        List<Group> groups = (List<Group>) userCriteria.list();
        session.close();
        return groups;
    }

    public List<Group> findByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Group.class);
        userCriteria.add(Restrictions.eq("gName",name));
        Group group = (Group) userCriteria.uniqueResult();
        List<Group> groups = new ArrayList<Group>();
        groups.add(group);
        return groups;
    }


    public List<Group> findAllGroup(){
        List<Group> groups = (List<Group>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Group").list();
        return groups;
    }
    public void save(Group group)  {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(group);
            tx1.commit();
            session.close();
    }
    public void update(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(group);
        tx1.commit();
        session.close();
    }
    public void delete(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(group);
        tx1.commit();
        session.close();
    }
}
