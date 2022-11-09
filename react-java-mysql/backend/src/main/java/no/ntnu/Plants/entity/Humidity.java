package no.ntnu.Plants.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="humidity")
public class Humidity {
    
    @Id
    private int humidityId;

    @OneToOne
    @JoinColumn(name="plantId")
    private Plant plant;

    private int humidity;


    public int getHumidity() {
        return humidity;
    }


    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Humidity(){

    }


}
