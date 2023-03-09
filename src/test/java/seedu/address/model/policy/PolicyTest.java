package seedu.address.model.policy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FREQUENCY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POLICYNAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POLICYNAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PREMIUM_BOB;
import static seedu.address.testutil.TypicalPolicy.HEALTH;
import static seedu.address.testutil.TypicalPolicy.LIFE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PolicyBuilder;

public class PolicyTest {

    @Test
    public void isSamePolicy() {
        // same object -> returns true
        assertTrue(HEALTH.isSamePolicy(HEALTH));

        // null -> returns false
        assertFalse(HEALTH.isSamePolicy(null));

        // name differs in case, all other attributes same -> returns false
        Policy editedBob = new PolicyBuilder(LIFE).withPolicyName(VALID_POLICYNAME_BOB.toLowerCase()).build();
        assertFalse(LIFE.isSamePolicy(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_POLICYNAME_BOB + " ";
        editedBob = new PolicyBuilder(LIFE).withPolicyName(nameWithTrailingSpaces).build();
        assertFalse(LIFE.isSamePolicy(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Policy aliceCopy = new PolicyBuilder(HEALTH).build();
        assertTrue(HEALTH.equals(aliceCopy));

        // same object -> returns true
        assertTrue(HEALTH.equals(HEALTH));

        // null -> returns false
        assertFalse(HEALTH.equals(null));

        // different type -> returns false
        assertFalse(HEALTH.equals(5));

        // different policy -> returns false
        assertFalse(HEALTH.equals(LIFE));

        // different policy name -> returns false
        Policy editedAmy = new PolicyBuilder(HEALTH).withPolicyName(VALID_POLICYNAME_AMY).build();
        assertFalse(HEALTH.equals(editedAmy));

        // different premium -> returns false
        editedAmy = new PolicyBuilder(HEALTH).withPremium(VALID_PREMIUM_BOB).build();
        assertFalse(HEALTH.equals(editedAmy));

        // different frequency -> returns false
        editedAmy = new PolicyBuilder(HEALTH).withFrequency(VALID_FREQUENCY_BOB).build();
        assertFalse(HEALTH.equals(editedAmy));

        // different date -> returns false
        editedAmy = new PolicyBuilder(HEALTH).withStartDate(VALID_DATE_BOB).build();
        assertFalse(HEALTH.equals(editedAmy));

    }
}
