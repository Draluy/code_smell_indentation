package firssnippet;

import firssnippet.logrequestor.LogRequestor;

public class Example1 implements LogRequestorFilter {
    public LogRequestor[] process(LogRequestor[] logRequestors, Class alclass) {
        for (int i = 0; i < logRequestors.length; i++) {
            if (logRequestors[i] != null && logRequestors[i].getClass().equals(alclass)) {
                // Make sure there's another stack frame.
                if (i + 1 < logRequestors.length) {
                    LogRequestor logRequestor = logRequestors[i + 1];
                    if (logRequestor.getClass().equals(alclass)) {
                        logRequestors[i + 1] = null;
                    } // Also AbstractLogger
                } // Found something that wasn't abstract logger
            } // check for abstract logger
        }
        return logRequestors;
    }
}
