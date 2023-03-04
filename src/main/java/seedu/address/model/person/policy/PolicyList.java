package seedu.address.model.person.policy;

import java.util.ArrayList;

public class PolicyList {

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