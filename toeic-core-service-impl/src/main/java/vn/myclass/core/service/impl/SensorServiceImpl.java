package vn.myclass.core.service.impl;

import vn.myclass.core.dao.SensorDao;
import vn.myclass.core.daoimpl.SensorDaoImpl;
import vn.myclass.core.dto.SensorDTO;
import vn.myclass.core.persistence.SensorEntity;
import vn.myclass.core.service.SensorService;
import vn.myclass.core.ultils.SensorBeanUtil;

public class SensorServiceImpl implements SensorService {
    private SensorDao sensorDao = new SensorDaoImpl();
    public void Save(SensorDTO sensorDTO) {
        SensorDao sensorDao = new SensorDaoImpl();
        SensorEntity sensorEntity = SensorBeanUtil.dto2Entity(sensorDTO);
        sensorDao.Save(sensorEntity);
    }
}
