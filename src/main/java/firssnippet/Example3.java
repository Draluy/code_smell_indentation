package firssnippet;

import firssnippet.logrequestor.LogRequestor;

public class Example3 implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        for (int i = 0; i < logRequestors.length; i++) {
            LogRequestor curentLogRequestor = logRequestors[i];
            if (isOfClass(curentLogRequestor, alclass)
                    && !isLastValue(logRequestors, i)
                    && isOfClass(logRequestors[i + 1], alclass)) {
                logRequestors[i + 1] = null;

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
