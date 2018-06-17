package vn.myclass.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.util.HibernateUtil;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {
    public UserEntity isUserExist(String name, String password) {
        UserEntity userEntity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            userEntity = (UserEntity) query.uniqueResult();
            transaction.commit();

        } catch(HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return userEntity;
    }

    public UserEntity FindRoleByUser(String name, String password) {
        UserEntity userEntity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            userEntity = (UserEntity) query.uniqueResult();
            transaction.commit();

        } catch(HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return userEntity;
    }

    public UserEntity FindName(String name) {
        UserEntity userEntity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name", name);
            userEntity = (UserEntity) query.uniqueResult();
            transaction.commit();

        } catch(HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return userEntity;
    }
}
