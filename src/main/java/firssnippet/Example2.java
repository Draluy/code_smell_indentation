package firssnippet;

import firssnippet.logrequestor.LogRequestor;

public class Example2 implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        for (int i = 0; i < logRequestors.length; i++) {
            LogRequestor curentLogRequestor = logRequestors[i];
            if (isOfClass(curentLogRequestor, alclass) && !isLastValue(logRequestors, i)) {
                LogRequestor nextLogRequestor = logRequestors[i + 1];
                if (isOfClass(nextLogRequestor, alclass)) {
                    logRequestors[i + 1] = null;
                }
            }
        }
        return logRequestors;
    }

    private boolean isLastValue(LogRequestor[] logRequestors, int i) {
        return logRequestors.length == (i + 1);
    }

    private boolean isOfClass(LogRequestor curentLogRequestor, Class alclass) {
        return curentLogRequestor != null && curentLogRequestor.getClass().equals(alclass);
    }
}
