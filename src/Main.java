import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by kenyr on 19.09.2017.
 */
public class Main {
    public static ArrayList<Profile> profiles = new ArrayList<Profile>();

    public static void main (String [] arg){
        profiles = (ArrayList<Profile>) desData("Profiles");
        System.out.println(profiles.size());
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Введите ваше имя"));
        profile.setSurname(JOptionPane.showInputDialog(null, "Введите вашу фамилию"));
        profiles.add(profile);

        for (Profile p : profiles){
            System.out.println(p.getName() +"  "+ p.getSurname());
        }
        System.out.println(profiles.size());
        serData("Profiles", profiles);
    }

    private static Object desData(String file_name) {
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(file_name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден");
            System.exit(3);
        }
        return retObject;
    }

    private static void serData(String file_name, Object obj) {
        try{
            FileOutputStream fileOut = new FileOutputStream (file_name+ ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
            System.exit(2);
        }
    }
}
