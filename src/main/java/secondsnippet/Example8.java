package secondsnippet;

import org.assertj.core.util.Streams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example8 extends SecondExample {

    public void computeRecommendations() {
        JSONObject json = new JSONObject(loadJSONFromAsset("recomendations.json"));

        //first step, populate the beer names and create the tuples
        Map<String, JSONArray> recommendationsMap = Streams.stream(json.keys())
                .peek(beerNames::add)
                .collect(Collectors.toMap(Function.identity(), json::getJSONArray));

        //second step, iterate over the recommendations
        recommendationsMap.forEach((key, recommendations) -> addRecommendations(key, recommendations));
    }

    private void addRecommendations(String key, JSONArray json) {
        if (recommendations.get(key) == null)
            recommendations.put(key, new ArrayList());

        List<String> recommendations = (List<String>) (List<?>) json.toList();
        this.recommendations.get(key).addAll(recommendations);
    }
}
