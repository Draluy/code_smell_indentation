package firssnippet;

import firssnippet.logrequestor.LogRequestor;

public interface LogRequestorFilter {
    LogRequestor[] process(LogRequestor[] logRequestors, Class alclass);
}
