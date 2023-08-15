import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager("files");


        String input = "";
        while (!input.equals(CommandEnum.EXIT.toString())) {
            try {
                System.out.print(fileManager.getCurrentFolder()+"\\ ");
                input = scanner.nextLine();
                String[] parameters = input.split(" ");

                CommandEnum commandEnum = CommandEnum.getByName(parameters[0]);

                switch (commandEnum) {
                    case LIST_OF_FILES -> fileManager.listOfFiles();
                    case COPY_FILE -> {
                        String sourceFileName = parameters[1];
                        String destFileName = parameters[2];
                        fileManager.copyFile(sourceFileName, destFileName);
                    }
                    case CREATE_FILE -> {
                        String fileName = parameters[1];
                        fileManager.createFile(fileName);
                    }
                    case REMOVE_FILE -> {
                        String fileName = parameters[1];
                        fileManager.removeFile(fileName);
                    }
                    case CREATE_FOLDER -> {
                        String folderName = parameters[1];
                        fileManager.createFolder(folderName);
                    }
                    case FILE_CONTENT -> {
                        String fileName = parameters[1];
                        fileManager.showContent(fileName);
                    }
                    case CHANGE_DIRECTORY -> {
                        String fileName = parameters[1];
                        fileManager.changeDirectory(fileName);
                    }

                }
            } catch (InvalidOperation e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Operation parameters are not entered");
            }
            catch (IOException e) {
                System.out.println("File not found");
            }


        }
    }
}
