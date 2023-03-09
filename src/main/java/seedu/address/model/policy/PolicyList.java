package seedu.address.model.policy;

import java.util.ArrayList;

/**
 * Represents a list of policies, implemented as an {@link ArrayList} of {@link Policy} objects.
 */
public class PolicyList extends ArrayList<Policy> {

    private ArrayList<Policy> policyList;

    /**
     * Field can be empty
     */
    public PolicyList(ArrayList<Policy> policyList) {
        this.policyList = policyList;
    }

    public ArrayList<Policy> getPolicyList() {
        return this.policyList;
    }
}
