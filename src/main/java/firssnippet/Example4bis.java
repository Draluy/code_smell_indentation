package firssnippet;

import firssnippet.logrequestor.LogRequestor;

import java.util.List;

public class Example4bis implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        final LogRequestor[] filteredLogRequestors = ArrayUtils.getAllButLastElement (logRequestors);
        List<Integer> logRequestorIndexes =  ArrayUtils.getIndexesOfElementsOfClass(filteredLogRequestors, alclass);

        logRequestorIndexes.stream()
                .filter(i -> logRequestors[i] != null)
                .forEach(i -> logRequestors[i + 1] = null);

        return logRequestors;
    }
}
