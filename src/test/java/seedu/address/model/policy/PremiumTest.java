package seedu.address.model.policy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PremiumTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Premium(null));
    }

    @Test
    public void constructor_invalidPremium_throwsIllegalArgumentException() {
        String invalidPremium = "";
        assertThrows(IllegalArgumentException.class, () -> new Premium(invalidPremium));
    }

    @Test
    public void isValidPremium() {
        // null premium
        assertThrows(NullPointerException.class, () -> Premium.isValidPremium(null));

        // invalid premiums
        assertFalse(Premium.isValidPremium("-100")); // negative values
        assertFalse(Premium.isValidPremium(" ")); // spaces only

        assertTrue(Premium.isValidPremium("300.43"));
        assertTrue(Premium.isValidPremium("80.43236"));
        assertTrue(Premium.isValidPremium("99.999"));
    }
}
