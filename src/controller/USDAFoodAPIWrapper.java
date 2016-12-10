package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import model.FoodDetail;
import model.FoodItem;
import model.FoodNutrient;
import model.FoodSearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@Controller
public class USDAFoodAPIWrapper {

    private static final String API_KEY = "EyKHrSltRSxgXJZrVt9VQ7hXhZVVDlebIM1btZlK";
    private static final String SEARCH_URL = "http://api.nal.usda.gov/ndb/search/?format=json&api_key=" + API_KEY + "&q=";
    private static final String REPORT_URL = "http://api.nal.usda.gov/ndb/reports/?format=json&type=f&api_key=" + API_KEY + "&ndbno=";

    private LinkedHashMap getResultMap(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap resultMap = restTemplate.getForObject(url, LinkedHashMap.class);
        return resultMap;
    }


    @RequestMapping(value = "/foodSearch" , method = RequestMethod.GET)
    public String searchFood()
    {
        return "foodSearch";
    }

    @ResponseBody
    @RequestMapping(value = "/foodList" , method = RequestMethod.GET, params = {"keyword"})
    public String searchFood(@RequestParam(value = "keyword") String keyword)
    {
        LinkedHashMap resultMap = getResultMap(SEARCH_URL + keyword);
        ObjectMapper mapper = new ObjectMapper();
        FoodSearchResult searchResult = mapper.convertValue(resultMap.get("list"), FoodSearchResult.class);
        List<FoodItem> foodList = searchResult.getItem();

        String json = "";
        try {
            json = mapper.writeValueAsString(foodList);
        } catch (Exception e) {
            e.printStackTrace();
        }

       /*ModelAndView model = new ModelAndView("foodSearch");


        String json = "";
        try {
            json = mapper.writeValueAsString(foodList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addObject("data", json);
        return model;*/
       return json;

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
