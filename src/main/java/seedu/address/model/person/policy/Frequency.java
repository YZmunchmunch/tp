package seedu.address.model.person.policy;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Frequency {

    public static final String MESSAGE_CONSTRAINTS = "Frequency can only take on any of the 3 values, \"weekly\", \"monthly\", \"yearly\", and it should not be blank";

    /*
     * The first character of the frequency must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    // public static final String VALIDATION_REGEX = "[^\\s].*";

    public final FrequencyEnum frequency;

    /**
     * Constructs an {@code Frequency}.
     *
     * @param freq A valid frequency.
     */
    public Frequency(FrequencyEnum freq) {
        requireNonNull(freq);
        //checkArgument(isValidFrequency(freq), MESSAGE_CONSTRAINTS);
        this.frequency = freq;
    }

//    /**
//     * Returns true if a given string is a valid email.
//     */
//    public static boolean isValidFrequency(String test) {
//        return test.matches(VALIDATION_REGEX);
//    }

    @Override
    public String toString() {
        return frequency.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Frequency // instanceof handles nulls
                && frequency.equals(((Frequency) other).frequency)); // state check
    }

    @Override
    public int hashCode() {
        return frequency.hashCode();
    }

}
