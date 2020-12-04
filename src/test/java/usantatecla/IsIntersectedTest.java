package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithSameMinThenReturnTrue() {
        Interval sameMinInterval = new IntervalBuilder().open(1).open(4).build();
        boolean isIntersected = this.interval.isIntersected(sameMinInterval);
        assertTrue(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithWithinIntervalThenReturnTrue() {
        Interval withinInterval = new IntervalBuilder().closed(2).closed(4).build();
        boolean isIntersected = this.interval.isIntersected(withinInterval);
        assertTrue(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithEnvelopingIntervalThenReturnTrue() {
        Interval envelopingInterval = new IntervalBuilder().closed(-1).closed(14).build();
        boolean isIntersected = this.interval.isIntersected(envelopingInterval);
        assertTrue(isIntersected);
    }


    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedIntersectingInTheLeftThenReturnTrue() {
        Interval leftIntersectInterval = new IntervalBuilder().closed(-1).closed(6).build();
        boolean isIntersected = this.interval.isIntersected(leftIntersectInterval);
        assertTrue(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedIntersectingInTheRightThenReturnTrue() {
        Interval rightIntersectInterval = new IntervalBuilder().closed(4).closed(60).build();
        boolean isIntersected = this.interval.isIntersected(rightIntersectInterval);
        assertTrue(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithNonIntersectingIntervalInTheRightThenReturnFalse() {
        Interval nonIntersectingInterval = new IntervalBuilder().closed(20).closed(60).build();
        boolean isIntersected = this.interval.isIntersected(nonIntersectingInterval);
        assertFalse(isIntersected);
    }

    @Test
    public void testGivenIntervalWhenCheckIfIsIntersectedWithNonIntersectingIntervalInTheLeftThenReturnFalse() {
        Interval nonIntersectingInterval = new IntervalBuilder().closed(-20).closed(-60).build();
        boolean isIntersected = this.interval.isIntersected(nonIntersectingInterval);
        assertFalse(isIntersected);
    }

}
