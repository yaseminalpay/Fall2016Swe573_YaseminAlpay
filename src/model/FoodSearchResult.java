package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodSearchResult {

     FoodListItem list[];

    public void setList(FoodListItem[] list) {
        this.list = list;
    }

    public FoodListItem[] getList() {
        return list;
    }
}
