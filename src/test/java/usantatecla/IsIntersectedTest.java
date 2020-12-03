package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IsIntersectedTest {

    private Interval interval;

    @Before
    public void before() {
        this.interval = new IntervalBuilder().open(1).open(10).build();
    }

    @Test(expected = AssertionError.class)
    public void testGivenIntervalWhenCheckIfIsIntersectedWithNullIntervalThenAssertionError() {
        this.interval.isIntersected(null);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithSameIntervalThenReturnTrue() {
        Interval sameInterval = new IntervalBuilder().open(1).open(10).build();
        boolean isIntersected = this.interval.isIntersected(sameInterval);
        assertTrue(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithSameMaxThenReturnTrue() {
        Interval sameMaxInterval = new IntervalBuilder().open(7).open(10).build();
        boolean isIntersected = this.interval.isIntersected(sameMaxInterval);
        assertTrue(isIntersected);
    }

}
