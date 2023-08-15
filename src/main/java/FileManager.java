import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileManager {
    private String currentFolder;
    private final String rootFolder;

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.rootFolder = currentFolder;
    }

    public void listOfFiles() {
        File currentFolderAsFile = new File(currentFolder);
        File[] files = currentFolderAsFile.listFiles();
        for (File file : files) {
            System.out.print(file.getName());
            if (file.isDirectory()) System.out.print("\\ ");
            System.out.println();
        }
    }

    public void copyFile(String sourceFileName, String destFileName) throws IOException {
        File source = new File(currentFolder + "\\" + sourceFileName);
        File dest = new File(currentFolder + "\\" + destFileName);
        FileUtils.copyFile(source, dest);
    }

    public void createFile(String fileName) {
        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFile(String fileName) throws FileNotFoundException {
        File file = new File(currentFolder + "\\" + fileName);
        if(file.exists()){
        file.delete();}
        else {
            throw new FileNotFoundException("File not found");
        }
    }
    public void showContent(String fileName) throws IOException {
        File file = new File(currentFolder + "\\" + fileName);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

    }

    public void changeDirectory(String fileName) {
        switch (fileName) {
            case "/" -> this.currentFolder = this.rootFolder;
            case ".." -> {
                int startLastFolderPosition = this.currentFolder.lastIndexOf("\\");
                this.currentFolder = this.currentFolder.substring(0, startLastFolderPosition);
            }
            default -> this.currentFolder = this.currentFolder + "\\" + fileName;
        }
    }

    public String getCurrentFolder() {
        return currentFolder;
    }

    public void createFolder(String folderName) {
        File file = new File(currentFolder + "\\" + folderName);
        file.mkdir();
    }
}
