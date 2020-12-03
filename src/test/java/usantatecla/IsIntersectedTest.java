package usantatecla;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class IsIntersectedTest {

    private Interval interval;

    @Before
    public void before() {
        this.interval = new IntervalBuilder().open(1).open(10).build();
    }

    @Test(expected = AssertionError.class)
    public void testGivenIntervalWhenCheckIfIsIntersectedWithNullIntervalThenAssertionError() {
        Interval nullInterval = null;
        boolean isIntersected = this.interval.isIntersected(nullInterval);
    }

}
