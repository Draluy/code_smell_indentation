package secondsnippet;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.MapEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SecondExampleTest {

    private final SecondExample secondExample;

    @Parameterized.Parameters
    public static Collection<SecondExample> secondExamples() {
        return Arrays.asList(
                new Example5(),
                new Example6(),
                new Example7(),
                new Example8());
    }

    public SecondExampleTest(SecondExample secondExample) {
        this.secondExample = secondExample;
    }

    @Test
    public void testComputeRecommendations() {
        secondExample.computeRecommendations();

        Assertions.assertThat(secondExample.getBeerNames()).contains("beer1", "beer2", "beer3");
        Assertions.assertThat(secondExample.getRecommendations()).contains(
                MapEntry.entry("beer1", Arrays.asList("rec1", "rec2")),
                MapEntry.entry("beer3", Arrays.asList("rec1", "rec3")));
    }
}
