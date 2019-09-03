package firssnippet;

import firssnippet.logrequestor.LogRequestor;

import java.util.stream.IntStream;

public class Example3bis implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        IntStream.range(0, logRequestors.length)
                .filter(i -> isOfClass(logRequestors[i], alclass))
                .filter(i -> !isLastValue(logRequestors, i))
                .filter(i -> isOfClass(logRequestors[i + 1], alclass))
                .forEach(i -> logRequestors[i + 1] = null);

        return logRequestors;
    }

    private boolean isLastValue(LogRequestor[] logRequestors, int i) {
        return logRequestors.length == (i + 1);
    }

    private boolean isOfClass(LogRequestor curentLogRequestor, Class alclass) {
        return curentLogRequestor != null && curentLogRequestor.getClass().equals(alclass);
    }
}
