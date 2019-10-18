package seedu.address.logic.cap.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.cap.parser.CliSyntax.PREFIX_CREDIT;
import static seedu.address.logic.cap.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.cap.parser.CliSyntax.PREFIX_FACULTY;
import static seedu.address.logic.cap.parser.CliSyntax.PREFIX_MODULE_CODE;
import static seedu.address.logic.cap.parser.CliSyntax.PREFIX_TITLE;

import seedu.address.logic.cap.commands.exceptions.CommandException;
import seedu.address.model.cap.Model;
import seedu.address.model.common.Module;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a module to the study tracker. "
            + "Parameters: "
            + PREFIX_MODULE_CODE + "MODULE CODE "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_FACULTY + "FACULTY "
            + PREFIX_CREDIT + "CREDIT "
            + PREFIX_DESCRIPTION + "DESCRIPTION ";

    public static final String MESSAGE_SUCCESS = "New module added to modulo tracker: %1$s";
    public static final String MESSAGE_DUPLICATE_MODULE = "This module already exists in this semester";

    private final Module toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Module module) {
        requireNonNull(module);
        toAdd = module;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasModule(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MODULE);
        }

        model.addModule(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
