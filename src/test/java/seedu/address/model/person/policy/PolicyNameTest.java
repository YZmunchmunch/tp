package seedu.address.model.person.policy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PolicyNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PolicyName(null));
    }

    @Test
    public void constructor_invalidPolicyName_throwsIllegalArgumentException() {
        String invalidPolicyName = "";
        assertThrows(IllegalArgumentException.class, () -> new PolicyName(invalidPolicyName));
    }

    @Test
    public void isValidPolicyName() {
        // null policy name
        assertThrows(NullPointerException.class, () -> PolicyName.isValidName(null));

        // invalid policy names
        assertFalse(PolicyName.isValidName("")); // empty string
        assertFalse(PolicyName.isValidName(" ")); // spaces only
        assertFalse(PolicyName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(PolicyName.isValidName("health*")); // contains non-alphanumeric characters

        assertTrue(PolicyName.isValidName("Health"));
        assertTrue(PolicyName.isValidName("Personal injury"));
        assertTrue(PolicyName.isValidName("Housing"));
    }
}
