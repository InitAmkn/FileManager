public enum CommandEnum {
    LIST_OF_FILES("ls"),
    COPY_FILE("cp"),
    CREATE_FILE("touch"),
    CREATE_FOLDER("mkdir"),
    REMOVE_FILE ("rm"),
    FILE_CONTENT("cat"),
    CHANGE_DIRECTORY("cd"),
    EXIT("exit");

    private String name;
    CommandEnum(String name)
    {
        this.name = name;
    }
    public static CommandEnum getByName (String name) throws InvalidOperation {
        for ( CommandEnum item : values () )
        {
            if ( item.name.equals(name) )
            {
                return item ;
            }
        }
        throw new InvalidOperation("Incorrect operation");
    }

    @Override
    public String toString() {
        return name;
    }
}
