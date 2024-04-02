package bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    public static List<Book> bookList = new ArrayList<>();
    public static File storage = new File("./src/bai9.storage.txt");
    // lấy data từ file ra
    private static List<Book> getBookList() {
        List<Book> listInput = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(storage);
            ois = new ObjectInputStream(fis);
            listInput = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return listInput;
    }
    // ghi đè lại dữ liệu vào file
    private static void updateFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(storage);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
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
        }
    }
    // thêm mới sách
    public static boolean addBook(Book book) {
        if (!storage.exists()) {// nếu file chưa có thì tạo mới file
            try {
                storage.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //thêm sách vào list
        bookList.add(book);
        //gọi lại method để cập nhật data vào file
        updateFile();
        return true;
    }
    // cập nhật sách
    public static boolean updateBook(Book book) {
        bookList = getBookList();// lấy data từ file
        if (bookList.stream().filter(book1 -> book1.getTitle().equals(book.getTitle())).count()==0){// kiểm tra nết sách cần cập nhật có tồn tại ko, nếu ko dừng hàm
            return false;
        }
        bookList.stream().filter(book1 -> book1.getTitle().equals(book.getTitle())).forEach(Book::inputData);// cập nhật bàng pthuc inputData
        updateFile();// cập nhật lại file
        return true;
    }


//xóa sách
    public static boolean deleteBook(String title) {
        boolean isRemoved = bookList.removeIf(book -> book.getTitle().equals(title));//removeif trả về true nếu xóa thành công, false nếu ko ptu nào đc xóa
        updateFile();// cập nhật lại file
        return isRemoved;
    }
    // hiển thị toàn bộ sách
    public static void displayAllBook() {
        List<Book> cloneList = getBookList();// lấy data từ file
        cloneList.stream().forEach(book -> System.out.println(book.toString()));// hiển thị bằng foreach
    }
}
