public enum Commands {
    LIST_OF_FILES("ls"),
    COPY_FILE("cp"),
    CREATE_FILE("touch"),
    FILE_CONTENT("cat"),
    CHANGE_DIRECTORY("cd"),
    EXIT("exit");

    String name;
    Commands(String name)
    {
        this.name = name;
    }
}
