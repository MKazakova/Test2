package afterTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.aftertest.exceptions.BadBadValueException;
import com.aftertest.races.TimeDuration;

public class TimeDurationTest{

    @Test
    public final void testZeroSeconds() {

        assertEquals("0s",new TimeDuration(0).toString());
    }

    @Test
    public final void testMinutesSeconds1() {

        assertEquals("12m 12s",new TimeDuration(732).toString());
    }

    @Test
    public final void testMinutesSeconds() {

        assertEquals("2h 0m 42s",new TimeDuration(7242).toString());
    }
}