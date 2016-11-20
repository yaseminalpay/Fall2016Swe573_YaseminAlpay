package controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.FoodListItem;
import model.FoodSearchResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@Controller
public class USDAApiWrapper {

    private static final String API_KEY = "my api key";
    private static final String SEARCH_URL =
            "http://api.nal.usda.gov/ndb/search/?format=json&sort=n&max=25&offset=0" +
            "&api_key=" + API_KEY + "&q=banana" ;

    @RequestMapping(value = "/foodSearch" , method = RequestMethod.GET)
    public List<FoodListItem> searchFood(@ModelAttribute("keyword") String keyword,
                                         ModelMap model)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(SEARCH_URL, Object.class);

        List<FoodListItem> foodList = new ArrayList<>();
        return foodList;
    }

}
