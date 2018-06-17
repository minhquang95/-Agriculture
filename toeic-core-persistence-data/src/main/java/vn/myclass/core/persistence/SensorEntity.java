package vn.myclass.core.persistence;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sensorentity")
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensorId;

    @Column(name = "sensorsold")
    private float sensorPH;

    @Column(name = "sensorwater")
    private int sensorWater;

    @Column(name = "sensorhumidity")
    private int sensorHumidity;

    @Column(name = "createddate")
    @UpdateTimestamp
    private Date createdDate;


//    @OneToMany(mappedBy = "sensorEntity", fetch = FetchType.LAZY)
//    private List<UserEntity> userEntityList;

//    public List<UserEntity> getUserEntityList() {
//        return userEntityList;
//    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public float getSensorPH() {
        return sensorPH;
    }

    public void setSensorPH(float sensorPH) {
        this.sensorPH = sensorPH;
    }

    public int getSensorWater() {
        return sensorWater;
    }

    public void setSensorWater(int sensorWater) {
        this.sensorWater = sensorWater;
    }

    public int getSensorHumidity() {
        return sensorHumidity;
    }

    public void setSensorHumidity(int sensorHumidity) {
        this.sensorHumidity = sensorHumidity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

//    public void setUserEntityList(List<UserEntity> userEntityList) {
//        this.userEntityList = userEntityList;
//    }
}
