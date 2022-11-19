package no.ntnu.Plants.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="humidity")
public class Humidity {
    public Humidity(){

    }

    public Humidity(Plant plant, int humidityPercent){
        this.humidityPercent = humidityPercent;
        this.plant = plant;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int humidityId;

    @OneToOne
    @JoinColumn(name="plantId")
    private Plant plant;

    private int humidityPercent;


    public int getHumidity() {
        return humidityPercent;
    }


    public void setHumidity(int humidity) {
        this.humidityPercent = humidity;
    }

    //todo add plantid



}
