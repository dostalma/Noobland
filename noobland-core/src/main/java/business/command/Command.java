/**
 *
 */
package business.command;

/**
 * @author Martin Dostál
 * Abstract command class
 */
public abstract class Command {

    CommandEnum commandType;

    protected Command(CommandEnum commandType) {
        this.commandType = commandType;
    }

}
