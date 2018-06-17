package vn.myclass.core.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class SensorDTO implements Serializable {
    private Integer sensorId;

    private float sensorPH;

    private int sensorWater;

    private int sensorHumidity;

    private Date createdDate;

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public float getSensorPH() {
        return sensorPH;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setSensorPH(float sensorPH) {
        if(sensorPH > 0){
            this.sensorPH = sensorPH;
        }
    }

    public int getSensorWater() {
        return sensorWater;
    }

    public void setSensorWater(int sensorWater) {
        if(sensorWater > 0){
            this.sensorWater = sensorWater;
        }
    }

    public int getSensorHumidity() {
        return sensorHumidity;
    }

    public void setSensorHumidity(int sensorHumidity) {
        if(sensorHumidity > 0){
            this.sensorHumidity = sensorHumidity;
        }
    }
}
