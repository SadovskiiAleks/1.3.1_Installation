import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Сохранение в стрингбилдере логов
        StringBuilder logOfInstaller = new StringBuilder();

        //Создать директорию для файлов
        List<String> directory= new ArrayList<String>(30);
        directory.add("A:/Games/src");
        directory.add("A:/Games/res");
        directory.add("A:/Games/savegames");
        directory.add("A:/Games/temp");

        directory.add("A:/Games/src/main");
        directory.add("A:/Games/src/test");

        directory.add("A:/Games/res/drawables");
        directory.add("A:/Games/res/vectors");
        directory.add("A:/Games/res/icons");

        for(String nameOffDirectory : directory) {
            File fileCreate = new File(nameOffDirectory);
            if (fileCreate.mkdir()) {
                logOfInstaller.append
                    ("Каталог создан в директории -> "
                    + nameOffDirectory
                    + "\n");
            } else {
                logOfInstaller.append
                    ("Каталог в директории -> "
                    + nameOffDirectory
                    + " не создан"
                    + "\n");
            }
        }

        //Создать файл в папке
        List<String> fileDirectory= new ArrayList<String>(30);
        fileDirectory.add("A:/Games/src/main/Main.java");
        fileDirectory.add("A:/Games/src/main/Utils.java");
        fileDirectory.add("A:/Games/temp/temp.txt");
        for(String nameOffDirectory : fileDirectory) {
            File fileCreate = new File(nameOffDirectory);
            try {
                if (fileCreate.createNewFile()) {
                    logOfInstaller.append
                        ("Файл в директории -> "
                        + nameOffDirectory
                        + " создан"
                        + "\n");
                } else {
                    logOfInstaller.append
                        ("Файл в директории -> "
                        + nameOffDirectory
                        + " не создан"
                        + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                logOfInstaller.append
                    ("Нет доступа к директории -> "
                    + nameOffDirectory
                    + " файл не создан"
                    + "\n");
            }
        }

        //Сохранить лог в Temp.txt
        try (FileWriter writer = new FileWriter("A:/Games/temp/temp.txt")){
            writer.write(String.valueOf(logOfInstaller));
            System.out.println("Игра установлена, лог записан");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}