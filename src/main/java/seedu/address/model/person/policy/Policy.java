package seedu.address.model.person.policy;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an insurance policy that contains its name, start date, premium, frequency, and tags.
 * A policy object is immutable, and all fields must be present and not null.
 */
public class Policy {

    // fields
    private final PolicyName name;
    private final LocalDate startdate;
    private final Premium premium;
    private final Frequency frequency;

    /**
     * Every field must be present and not null.
     */
    public Policy(PolicyName name, LocalDate startdate, Premium premium, Frequency frequency) {
        requireAllNonNull(name, startdate, premium, frequency);
        this.name = name;
        this.startdate = startdate;
        this.premium = premium;
        this.frequency = frequency;
    }

    public PolicyName getPolicyName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startdate;
    }

    public Premium getPremium() {
        return premium;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, startdate, premium, frequency);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getPolicyName())
                .append("; Policy: ")
                .append(getStartDate())
                .append("; Start Date: ")
                .append(getPremium())
                .append("; Premium: ")
                .append(getFrequency());

        return builder.toString();
    }
}
