package secondsnippet;

import org.json.JSONObject;

import java.util.*;

public class Example6 extends SecondExample{

    public void computeRecommendations() {
        JSONObject json = new JSONObject(loadJSONFromAsset("recomendations.json"));
        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            String key = it.next();
            for (int i = 0; i < json.getJSONArray(key).length(); i++) {
                doStuff(json, key, i);
            }
            beerNames.add(key);
        }
    }

    private void doStuff(JSONObject json, String key, int i) {
        if (recommendations.get(key) == null)
            recommendations.put(key, new ArrayList());
        recommendations.get(key).add(json.getJSONArray(key).get(i).toString());
    }
}
