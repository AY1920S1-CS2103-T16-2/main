package seedu.address.logic.finance.parser;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.finance.parser.exceptions.ParseException;
import seedu.address.model.finance.attributes.Amount;
import seedu.address.model.finance.attributes.Category;
import seedu.address.model.finance.attributes.Description;
import seedu.address.model.finance.attributes.Person;
import seedu.address.model.finance.attributes.Place;
import seedu.address.model.finance.attributes.TransactionDate;
import seedu.address.model.finance.attributes.TransactionMethod;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String amount} into a {@code Amount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code amount} is invalid.
     */
    public static Amount parseAmount(String amount) throws ParseException {
        requireNonNull(amount);
        String trimmedAmount = amount.trim();
        if (!Amount.isValidAmount(trimmedAmount)) {
            throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
        }
        return new Amount(trimmedAmount);
    }

    /**
     * Parses a {@code String tDate} into a {@code TransactionDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tDate} is invalid.
     */
    public static TransactionDate parseTransactionDate(String tDate) throws ParseException {
        requireNonNull(tDate);
        String trimmedTDate = tDate.trim();
        if (!TransactionDate.isValidTransactionDate(trimmedTDate)) {
            throw new ParseException(TransactionDate.MESSAGE_CONSTRAINTS);
        }
        return new TransactionDate(trimmedTDate);
    }

    /**
     * Parses a {@code String d} into an {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code d} is invalid.
     */
    public static Description parseDescription(String d) throws ParseException {
        requireNonNull(d);
        String trimmedDesc = d.trim();
        if (!Description.isValidDescription(trimmedDesc)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDesc);
    }

    /**
     * Parses a {@code String tMethod} into an {@code TransactionMethod}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tMethod} is invalid.
     */
    public static TransactionMethod parseTransactionMethod(String tMethod) throws ParseException {
        requireNonNull(tMethod);
        String trimmedTMethod = tMethod.trim();
        if (!TransactionMethod.isValidTransactionMet(trimmedTMethod)) {
            throw new ParseException(TransactionMethod.MESSAGE_CONSTRAINTS);
        }
        return new TransactionMethod(trimmedTMethod);
    }

    /**
     * Parses a {@code String cat} into a {@code Category}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code cat} is invalid.
     */
    public static Category parseCategory(String cat) throws ParseException {
        requireNonNull(cat);
        String trimmedCat = cat.trim();
        if (!Category.isValidCatName(trimmedCat)) {
            throw new ParseException(Category.MESSAGE_CONSTRAINTS);
        }
        return new Category(trimmedCat);
    }

    /**
     * Parses {@code Collection<String> cats} into a {@code Set<Category>}.
     */
    public static Set<Category> parseCategories(Collection<String> cats) throws ParseException {
        requireNonNull(cats);
        final Set<Category> catSet = new HashSet<>();
        for (String catName : cats) {
            catSet.add(parseCategory(catName));
        }
        return catSet;
    }

    /**
     * Parses a {@code String p} into an {@code Place}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code p} is invalid.
     */
    public static Place parsePlace(String p) throws ParseException {
        requireNonNull(p);
        String trimmedPlace = p.trim();
        if (!Place.isValidPlace(trimmedPlace)) {
            throw new ParseException(Place.MESSAGE_CONSTRAINTS);
        }
        return new Place(trimmedPlace);
    }

    /**
     * Parses a {@code String name} into an {@code Person}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Person parsePerson(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Person.isValidName(trimmedName)) {
            throw new ParseException(Person.MESSAGE_CONSTRAINTS);
        }
        return new Person(trimmedName);
    }

    /**
     * Parses a {@code String sortAttr} into an {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     * Valid inputs are "day" and "amt" (case insensitive).
     *
     * @throws ParseException if the given {@code sortAttr} is invalid.
     */
    public static String parseSort(String sortAttr) throws ParseException {
        requireNonNull(sortAttr);
        String trimmedAttr = sortAttr.trim().toLowerCase();
        if (!trimmedAttr.equals("day") && !trimmedAttr.equals("amt")) {
            throw new ParseException("Sort attribute should either be \"day\" or \"amt\"!");
        }
        return trimmedAttr;
    }

    /**
     * Parses {@code Collection<String> filterTypes} into a {@code Set<String>}.
     * Valid log entry types to filter by are "spend", "income", "borrow", "lend".
     * Case insensitive.
     */
    public static ArrayList<String> parseFilterTypes(String types) throws ParseException {
        requireNonNull(types);
        String[] typeList = types.trim().split("\\s+");
        final ArrayList<String> typeSet = new ArrayList<String>();
        for (String currType : typeList) {
            String t = currType.toLowerCase();
            if (!t.equals("spend") && !t.equals("income")
                && !t.equals("borrow") && !t.equals("lend")) {
                throw new ParseException("Filter attribute should either be"
                        + "\"spend\", \"income\", \"borrow\" or \"lend\"!");
            }
            typeSet.add(t);
        }
        return typeSet;
    }

}
