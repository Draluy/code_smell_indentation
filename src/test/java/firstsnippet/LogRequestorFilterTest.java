package firstsnippet;

import firssnippet.*;
import firssnippet.logrequestor.LogRequestor;
import firssnippet.logrequestor.SubLogRequestor;
import firssnippet.logrequestor.SubLogRequestor2;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LogRequestorFilterTest {
    private LogRequestorFilter logRequestorFilter;

    @Parameterized.Parameters
    public static Collection<LogRequestorFilter> filters() {
        return Arrays.asList(new Example1(),
                new Example2(),
                new Example3(),
                new Example4());
    }

    public LogRequestorFilterTest(LogRequestorFilter filter) {
        this.logRequestorFilter = filter;
    }

    @Test
    public void shouldFilterASingleLogRequestor() {
        LogRequestor subLogRequestor = new SubLogRequestor();
        LogRequestor subLogRequestor2 = new SubLogRequestor2();
        LogRequestor[] arr = new LogRequestor[]{subLogRequestor, subLogRequestor2, subLogRequestor2};

        LogRequestor[] res = logRequestorFilter.process(arr, SubLogRequestor2.class);
        System.out.println(Arrays.toString(res));
        Assertions.assertThat(res).containsExactly(subLogRequestor, subLogRequestor2, null);
    }

    @Test
    public void shouldFilterMultipleConsecutiveLogRequestors() {
        LogRequestor subLogRequestor = new SubLogRequestor();
        LogRequestor subLogRequestor2 = new SubLogRequestor2();
        LogRequestor subLogRequestor3 = new SubLogRequestor2();
        LogRequestor subLogRequestor4 = new SubLogRequestor2();
        LogRequestor subLogRequestor5 = new SubLogRequestor2();
        LogRequestor[] arr = new LogRequestor[]{subLogRequestor, null, subLogRequestor, subLogRequestor2, subLogRequestor3, subLogRequestor4, subLogRequestor5};

        LogRequestor[] res = logRequestorFilter.process(arr, SubLogRequestor2.class);
        System.out.println(Arrays.toString(res));
        Assertions.assertThat(res).containsExactly(subLogRequestor, null,subLogRequestor,  subLogRequestor2, null, subLogRequestor4, null);
    }

    @Test
    public void shouldReturnEmptyArray() {
        LogRequestor[] arr = new LogRequestor[]{};

        LogRequestor[] res = logRequestorFilter.process(arr, SubLogRequestor2.class);
        System.out.println(Arrays.toString(res));
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void shouldPreserveNullValues() {
        LogRequestor[] arr = new LogRequestor[]{null};

        LogRequestor[] res = logRequestorFilter.process(arr, SubLogRequestor2.class);
        System.out.println(Arrays.toString(res));
        Assertions.assertThat(res[0]).isNull();
    }
}