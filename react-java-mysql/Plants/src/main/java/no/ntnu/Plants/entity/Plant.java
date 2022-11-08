package no.ntnu.Plants.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plant {
    
    @Id
    private int plantId;
    private String plantName;
    private String plantPercentages;
    private String plantLatinName;


    public Plant() {
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantPercentages() {
        return plantPercentages;
    }

    public void setPlantPercentages(String plantPercentages) {
        this.plantPercentages = plantPercentages;
    }

    public String getPlantLatinName() {
        return plantLatinName;
    }

    public void setPlantLatinName(String plantLatinName) {
        this.plantLatinName = plantLatinName;
    }

    
}
