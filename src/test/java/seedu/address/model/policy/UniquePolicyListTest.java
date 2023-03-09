package seedu.address.model.policy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FREQUENCY_AMY;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPolicy.HEALTH;
import static seedu.address.testutil.TypicalPolicy.LIFE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.client.exceptions.DuplicatePolicyException;
import seedu.address.model.client.exceptions.PolicyNotFoundException;
import seedu.address.testutil.PolicyBuilder;

public class UniquePolicyListTest {

    private final UniquePolicyList uniquePolicyList = new UniquePolicyList();

    @Test
    public void contains_policyNotInList_returnsFalse() {
        assertFalse(uniquePolicyList.contains(HEALTH));
    }

    @Test
    public void contains_policyInList_returnsTrue() {
        uniquePolicyList.add(HEALTH);
        assertTrue(uniquePolicyList.contains(HEALTH));
    }

    @Test
    public void contains_policyWithSameIdentityFieldsInList_returnsTrue() {
        uniquePolicyList.add(HEALTH);
        Policy editedAmy = new PolicyBuilder(HEALTH).withFrequency(VALID_FREQUENCY_AMY)
                .build();
        assertTrue(uniquePolicyList.contains(editedAmy));
    }

    @Test
    public void add_nullPolicy_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.add(null));
    }

    @Test
    public void add_duplicatePolicy_throwsDuplicatePolicyException() {
        uniquePolicyList.add(HEALTH);
        assertThrows(DuplicatePolicyException.class, () -> uniquePolicyList.add(HEALTH));
    }

    @Test
    public void setPolicy_nullTargetPolicy_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.setPolicy(null, HEALTH));
    }

    @Test
    public void setPolicy_nullEditedPolicy_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.setPolicy(HEALTH, null));
    }

    @Test
    public void setPolicy_targetPolicyNotInList_throwsPolicyNotFoundException() {
        assertThrows(PolicyNotFoundException.class, () -> uniquePolicyList.setPolicy(HEALTH, HEALTH));
    }

    @Test
    public void setPolicy_editedPolicyIsSamePolicy_success() {
        uniquePolicyList.add(HEALTH);
        uniquePolicyList.setPolicy(HEALTH, HEALTH);
        UniquePolicyList expectedUniquePolicyList = new UniquePolicyList();
        expectedUniquePolicyList.add(HEALTH);
        assertEquals(expectedUniquePolicyList, uniquePolicyList);
    }


    @Test
    public void setPolicy_editedPolicyHasDifferentIdentity_success() {
        uniquePolicyList.add(HEALTH);
        uniquePolicyList.setPolicy(HEALTH, LIFE);
        UniquePolicyList expectedUniquePolicyList = new UniquePolicyList();
        expectedUniquePolicyList.add(LIFE);
        assertEquals(expectedUniquePolicyList, uniquePolicyList);
    }

    @Test
    public void setPolicy_editedPolicyHasNonUniqueIdentity_throwsDuplicatePolicyException() {
        uniquePolicyList.add(HEALTH);
        uniquePolicyList.add(LIFE);
        assertThrows(DuplicatePolicyException.class, () -> uniquePolicyList.setPolicy(HEALTH, LIFE));
    }

    @Test
    public void remove_nullPolicy_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.remove(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPolicyNotFoundException() {
        assertThrows(PolicyNotFoundException.class, () -> uniquePolicyList.remove(HEALTH));
    }

    @Test
    public void remove_existingPolicy_removesPolicy() {
        uniquePolicyList.add(HEALTH);
        uniquePolicyList.remove(HEALTH);
        UniquePolicyList expectedUniquePolicyList = new UniquePolicyList();
        assertEquals(expectedUniquePolicyList, uniquePolicyList);
    }

    @Test
    public void setPolicies_nullUniquePolicyList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.setPolicies((UniquePolicyList) null));
    }

    @Test
    public void setPolicies_uniquePolicyList_replacesOwnListWithProvidedUniquePolicyList() {
        uniquePolicyList.add(HEALTH);
        UniquePolicyList expectedUniquePolicyList = new UniquePolicyList();
        expectedUniquePolicyList.add(LIFE);
        uniquePolicyList.setPolicies(expectedUniquePolicyList);
        assertEquals(expectedUniquePolicyList, uniquePolicyList);
    }

    @Test
    public void setPolicies_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniquePolicyList.setPolicies((List<Policy>) null));
    }

    @Test
    public void setPolicies_list_replacesOwnListWithProvidedList() {
        uniquePolicyList.add(HEALTH);
        List<Policy> personList = Collections.singletonList(LIFE);
        uniquePolicyList.setPolicies(personList);
        UniquePolicyList expectedUniquePolicyList = new UniquePolicyList();
        expectedUniquePolicyList.add(LIFE);
        assertEquals(expectedUniquePolicyList, uniquePolicyList);
    }

    @Test
    public void setPolicys_listWithDuplicatePolicies_throwsDuplicatePolicyException() {
        List<Policy> listWithDuplicatePolicies = Arrays.asList(HEALTH, HEALTH);
        assertThrows(DuplicatePolicyException.class, () -> uniquePolicyList.setPolicies(listWithDuplicatePolicies));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
                -> uniquePolicyList.asUnmodifiableObservableList().remove(0));
    }
}
