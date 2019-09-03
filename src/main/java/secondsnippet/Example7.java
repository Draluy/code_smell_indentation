package secondsnippet;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Example7 extends SecondExample {

    public void computeRecommendations() {
        JSONObject json = new JSONObject(loadJSONFromAsset( "recomendations.json"));

        //first step, populate the beer names
        json.keys().forEachRemaining(beerNames::add);

        //second step, iterate over the recommendations
        beerNames.forEach(key -> {
            for (int i = 0; i < json.getJSONArray(key).length(); i++) {
                doStuff(json, key, i);
            }
        });
    }

    private void doStuff(JSONObject json, String key, int i) {
        if (recommendations.get(key) == null)
            recommendations.put(key, new ArrayList<>());
        recommendations.get(key).add(json.getJSONArray(key).get(i).toString());
    }
}
