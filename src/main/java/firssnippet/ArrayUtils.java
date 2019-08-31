package firssnippet;

import firssnippet.logrequestor.LogRequestor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

    public static LogRequestor[] getAllButLastElement(LogRequestor[] logRequestors) {
        return Arrays.copyOfRange(logRequestors, 0, logRequestors.length > 0 ? logRequestors.length - 1 : 0);
    }

    public static List<Integer> getIndexesOfElementsOfClass(LogRequestor[] logRequestors, Class alclass) {
        return IntStream.range(0, logRequestors.length).boxed()
                .filter(i -> logRequestors[i] != null)
                .filter(i -> logRequestors[i].getClass().equals(alclass))

                .collect(Collectors.toList());
    }
}
