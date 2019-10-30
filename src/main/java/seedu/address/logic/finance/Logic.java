package seedu.address.logic.finance;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.finance.commands.CommandResult;
import seedu.address.logic.finance.commands.exceptions.CommandException;
import seedu.address.logic.finance.parser.exceptions.ParseException;
import seedu.address.model.finance.GraphicsData;
import seedu.address.model.finance.ReadOnlyFinanceLog;
import seedu.address.model.finance.logentry.LogEntry;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the finance log
     *
     * @see seedu.address.model.finance.Model#getFinanceLog()
     */
    ReadOnlyFinanceLog getFinanceLog();

    /** Returns an unmodifiable view of the filtered list of log entries */
    ObservableList<LogEntry> getFilteredLogEntryList();

    /** Returns a {@code GraphicsData} object */
    GraphicsData getGraphicsData();

    /**
     * Returns the user prefs' finance log file path.
     */
    Path getFinanceLogFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
