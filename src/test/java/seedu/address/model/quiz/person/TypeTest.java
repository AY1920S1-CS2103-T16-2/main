package seedu.address.model.quiz.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.quiz.person.Type;

public class TypeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Type(null));
    }

    @Test
    public void constructor_invalidType_throwsIllegalArgumentException() {
        String invalidType = "";
        assertThrows(IllegalArgumentException.class, () -> new Type(invalidType));
    }

    @Test
    public void isValidType() {
        // null address
        assertThrows(NullPointerException.class, () -> Type.isValidType(null));

        // invalid addresses
        assertFalse(Type.isValidType("")); // empty string
        assertFalse(Type.isValidType(" ")); // spaces only

        // valid addresses
        assertTrue(Type.isValidType("low"));
        assertTrue(Type.isValidType("normal"));
        assertTrue(Type.isValidType("high"));
    }
}
