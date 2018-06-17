package vn.myclass.core.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.util.HibernateUtil;
import vn.myclass.core.dao.SensorDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.SensorEntity;

public class SensorDaoImpl extends AbstractDao<Integer,SensorEntity> implements SensorDao {

//    public SensorEntity saveSensor(int sensorHumidity, int sensorWaterFlow, float sensorPH) {
//        SensorEntity sensorEntity = new SensorEntity();
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        return null;
//    }
}
