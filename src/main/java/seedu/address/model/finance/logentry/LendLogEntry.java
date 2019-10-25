package seedu.address.model.finance.logentry;

import java.util.Set;

import seedu.address.model.finance.attributes.Amount;
import seedu.address.model.finance.attributes.Category;
import seedu.address.model.finance.attributes.Description;
import seedu.address.model.finance.attributes.Person;
import seedu.address.model.finance.attributes.TransactionDate;
import seedu.address.model.finance.attributes.TransactionMethod;

/**
 * Represents an entry of lending to someone in the finance log.
 * Guarantees: details are present and not null, field values are validated, mutable.
 */
public class LendLogEntry extends LogEntry {

    // Meta data
    public static final String LOG_ENTRY_TYPE = "lend";
    private static boolean isRepaid; // whether person who borrowed money has returned to user

    // Fields
    private final Person to; // person lent to

    /**
     * Every field must be present and not null.
     */
    public LendLogEntry(Amount amount, TransactionDate transactionDate, Description description,
                        TransactionMethod transactionMethod, Set<Category> categories,
                        Person to) {
        super(amount, transactionDate, description,
                transactionMethod, categories);
        this.to = to;
        this.isRepaid = false;
    }

    public String getLogEntryType() {
        return LOG_ENTRY_TYPE;
    }

    public Person getTo() {
        return to;
    }

    public boolean isRepaid() {
        return isRepaid;
    }

    public void setAsRepaid() {
        isRepaid = true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LendLogEntry)) {
            return false;
        }

        LendLogEntry otherLogEntry = (LendLogEntry) other;
        return otherLogEntry.getAmount().equals(getAmount())
                && otherLogEntry.getTransactionDate().equals(getTransactionDate())
                && otherLogEntry.getDescription().equals(getDescription())
                && otherLogEntry.getTransactionMethod().equals(getTransactionMethod())
                && otherLogEntry.getCategories().equals(getCategories())
                && otherLogEntry.getTo().equals(getTo())
                && (otherLogEntry.isRepaid() == isRepaid());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Amount: ")
                .append(getAmount())
                .append(" Transaction Date: ")
                .append(getTransactionDate())
                .append(" Description: ")
                .append(getDescription())
                .append(" Transaction Method: ")
                .append(getTransactionMethod())
                .append(" To: ")
                .append(getTo())
                .append(" Categories: ");
        getCategories().forEach(builder::append);
        return builder.toString();
    }
}
