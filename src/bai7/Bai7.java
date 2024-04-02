package bai7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bai7 {
    public static void main(String[] args) {
        List<Student> listOuput = new ArrayList<>();
        List<Student> listInput =new ArrayList<>();
        ///test
        Student student1 = new Student("Khanh", 1);
        Student student2 = new Student("Hoang", 2);
        Student student3 = new Student("Hung", 3);
        Student student4 = new Student("Linh", 4);
        Student student5 = new Student("Ngoc", 5);
        listOuput.add(student1);
        listOuput.add(student2);
        listOuput.add(student3);
        listOuput.add(student4);
        listOuput.add(student5);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        //////ghi file
        try {
            fos = new FileOutputStream("./src/bai7/test.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listOuput);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ////////////// đọc file
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream("./src/bai7/test.txt");
                ois =new ObjectInputStream(fis);
                listInput = (List<Student>) ois.readObject();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fis!=null){
                        fis.close();
                    }
                    if (ois!=null){
                        ois.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(listInput);
    }
}
