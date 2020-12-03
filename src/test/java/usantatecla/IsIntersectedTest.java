package usantatecla;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

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
        boolean isIntersected = this.interval.isIntersected(this.interval);
        assertTrue(isIntersected);
    }

}
