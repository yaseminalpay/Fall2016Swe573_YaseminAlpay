package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.FoodDetail;
import model.FoodItem;
import model.FoodNutrient;
import model.FoodSearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@Controller
public class USDAFoodAPIWrapper {

    private static final String API_KEY = "MY AWESOME API KEY";
    private static final String SEARCH_URL = "http://api.nal.usda.gov/ndb/search/?format=json&api_key=" + API_KEY + "&q=";
    private static final String REPORT_URL = "http://api.nal.usda.gov/ndb/reports/?format=json&type=f&api_key=" + API_KEY + "&ndbno=";

    private LinkedHashMap getResultMap(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap resultMap = restTemplate.getForObject(url, LinkedHashMap.class);
        return resultMap;
    }

    @RequestMapping(value = "/foodSearch" , method = RequestMethod.GET)
    public List<FoodItem> searchFood(String keyword)
    {
        LinkedHashMap resultMap = getResultMap(SEARCH_URL + keyword);
        ObjectMapper mapper = new ObjectMapper();
        FoodSearchResult searchResult = mapper.convertValue(resultMap.get("list"), FoodSearchResult.class);
        List<FoodItem> foodList = searchResult.getItem();
        return foodList;
    }

    //TODO: fix value and parameter: keyword
    //@RequestMapping(value = "/foodDetails" , method = RequestMethod.GET)
    public List<FoodNutrient> getFoodNutrients(String ndbno)
    {
        LinkedHashMap resultMap = getResultMap(REPORT_URL + "45045772");
        LinkedHashMap foodMap = (LinkedHashMap)resultMap.get("report");
        ObjectMapper mapper = new ObjectMapper();
        FoodDetail foodDetail = mapper.convertValue(foodMap.get("food"), FoodDetail.class);
        List<FoodNutrient> nutrientsList = foodDetail.getNutrients();
        return nutrientsList;
    }




}
