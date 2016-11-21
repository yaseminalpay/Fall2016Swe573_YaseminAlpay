package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Yasemin Alpay on 21.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDetail {

    String ndbno;
    String name;
    String ds;
    List<FoodNutrient> nutrients;

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public List<FoodNutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<FoodNutrient> nutrients) {
        this.nutrients = nutrients;
    }
}
