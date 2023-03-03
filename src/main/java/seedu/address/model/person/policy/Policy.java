package seedu.address.model.person.policy;

import seedu.address.model.tag.Tag;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Policy {

    // fields
    private final PolicyName name;
    private final LocalDate startdate;
    private final Premium premium;
    private final Frequency frequency;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Policy(PolicyName name, LocalDate startdate, Premium premium, Frequency frequency, Set<Tag> tags) {
        requireAllNonNull(name, startdate, premium, frequency, tags);
        this.name = name;
        this.startdate = startdate;
        this.premium = premium;
        this.frequency = frequency;
        this.tags.addAll(tags);
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

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, startdate, premium, frequency, tags);
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

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }
}
