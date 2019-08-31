package secondsnippet;

import java.util.*;

public abstract class SecondExample {

    protected Map<String, List<String>> recommendations = new HashMap<>();
    protected List<String> beerNames = new ArrayList<>();

    abstract void computeRecommendations();

    protected Map<?, ?> loadJSONFromAsset(String s) {
        HashMap<String, Object> json = new HashMap<>();
        json.put("beer1", Arrays.asList("rec1", "rec2"));
        json.put("beer2", Collections.emptyList());
        json.put("beer3", Arrays.asList("rec1", "rec3"));

        return json;
    }

    public Map<String, List<String>> getRecommendations() {
        return recommendations;
    }

    public List<String> getBeerNames() {
        return beerNames;
    }
}
