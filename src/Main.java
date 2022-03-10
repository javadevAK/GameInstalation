import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static final String PATH = "D:\\Java\\Games\\";
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        createFolder("src");
        createFolder("res");
        createFolder("savegames");
        createFolder("temp");
        createFolder("src\\main");
        createFolder("src\\test");
        createFolder("res\\drawables");
        createFolder("res\\vectors");
        createFolder("res\\icons");
        createFile("src\\main\\Main.java");
        createFile("src\\main\\Utils.java");
        createFile("temp\\temp.txt");
        String text = sb.toString();
        writeFile(text);
    }

    public static void createFolder(String directory) {
        File dir = new File(PATH + directory);
        if (dir.mkdir())
            sb.append("Каталог " + directory + " создан \n");
        else
            sb.append("Каталог " + directory + " уже существует \n");
    }

    public static void createFile(String fileName) {
        File logFile = new File(fileName);
        try {
            if (logFile.createNewFile())
                sb.append("Файл " + fileName + " был создан \n");
            else
                sb.append("Файл " + fileName + " уже существует \n");

        } catch (IOException ex) {
            sb.append(ex.getMessage());
        }
    }

    public static void writeFile(String text) {
        try (FileWriter writer = new FileWriter(PATH + "temp\\temp.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
