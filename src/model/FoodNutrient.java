package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Yasemin Alpay on 21.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodNutrient {
    String nutrient_id;
    String name;
    String group;
    String unit;
    String value;

    public String getNutrient_id() {
        return nutrient_id;
    }

    public void setNutrient_id(String nutrient_id) {
        this.nutrient_id = nutrient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
