package seedu.address.model.policy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;


public class FrequencyTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Frequency(null));
    }

    @Test
    public void constructor_invalidFrequency_throwsIllegalArgumentException() {
        String invalidFrequency = "";
        assertThrows(IllegalArgumentException.class, () -> new Frequency(invalidFrequency));
    }

    @Test
    public void isValidFrequency() {
        // null frequency
        assertThrows(NullPointerException.class, () -> Frequency.isValidFrequency(null));

        // invalid frequencies
        assertFalse(Frequency.isValidFrequency("")); // empty string
        assertFalse(Frequency.isValidFrequency(" ")); // spaces only


        // only 3 valid frequency
        assertTrue(Frequency.isValidFrequency("monthly"));
        assertTrue(Frequency.isValidFrequency("quarterly"));
        assertTrue(Frequency.isValidFrequency("yearly"));
    }
}
