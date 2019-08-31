package firssnippet;

import firssnippet.logrequestor.LogRequestor;

import java.util.List;

public class Example4 implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        final LogRequestor[] filteredLogRequestors = ArrayUtils.getAllButLastElement (logRequestors);
        List<Integer> logRequestorIndexes =  ArrayUtils.getIndexesOfElementsOfClass(filteredLogRequestors, alclass);

        for (Integer index : logRequestorIndexes ){
            LogRequestor logRequestor = logRequestors[index];
            if (logRequestor != null) {
                logRequestors[index + 1] = null;
            }
        }

        return logRequestors;
    }
}
