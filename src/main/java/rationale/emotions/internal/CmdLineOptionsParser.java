package rationale.emotions.internal;

/**
 * A utility class that helps in parsing command arguments.
 * 
 */
public class CmdLineOptionsParser {
    private String[] args;

    /**
     * @param args - The arguments that are to be parsed.
     */
    public CmdLineOptionsParser(String[] args) {
        this.args = args;
    }

    /**
     * @param name - The name of the parameter which is to be checked.
     * @return - <code>true</code> if the given parameter was specified by the user.
     */
    public boolean isParamPresent(String name) {
        if (! doesParamBeginWithHash(name)){
            throw new IllegalArgumentException(name + " doesn't begin with a '#' symbol.");
        }

        for (String arg : args) {
            if (name.equalsIgnoreCase(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param name - Name of the parameter.
     * @return - <code>true</code> if the parameter begins with a '#' symbol.
     */
    private boolean doesParamBeginWithHash(String name){
        return name.startsWith("#");
    }

    /**
     * @param name - Name of the parameter whose value is to be retrieved.
     * @return - The value of the parameter as an int.
     */
    public int getParamValue(String name) {
        if (! doesParamBeginWithHash(name)){
            throw new IllegalArgumentException(name + " doesn't begin with a '#' symbol.");
        }
        int index = -1;
        for (int i = 0; i < args.length; i++) {
            if (name.equalsIgnoreCase(args[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException(name + " was not provided at all.");
        }
        if (index == args.length) {
            throw new IllegalArgumentException(name + " was specified but no value specified for it.");
        }
        try {
            String value = "";
            if (((index + 1) < args.length) && !args[index + 1].startsWith("#")) {
                value = args[index + 1];
                return Integer.parseInt(value);
            }
            throw new IllegalArgumentException(name + " was specified but no value specified for it.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
