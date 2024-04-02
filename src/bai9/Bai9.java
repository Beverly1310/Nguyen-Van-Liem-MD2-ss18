package bai9;

import java.util.List;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit){
            System.out.println("-----------------Menu-----------------");
            System.out.println("1.Them sach");
            System.out.println("2.Cap nhat sach");
            System.out.println("3.Xoa sach");
            System.out.println("4.Hien thi toan bo sach");
            System.out.println("5. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addData(scanner);//thêm mới sachs
                    break;
                case 2:
                    updateData(scanner);// cập nhật sách
                    break;
                case 3:// xóa sách
                    System.out.println("Nhap ten sach can xoa");
                    System.out.println(BookManager.deleteBook(scanner.nextLine()) ? "Xoa thanh cong" : "Sach khong ton tai");
                    break;
                case 4:// hiển thị toàn bộ sách
                    BookManager.displayAllBook();
                    break;
                case 5:
                    isExit=true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void updateData(Scanner scanner) {
        System.out.println("Nhap ten sach can cap nhat:");
        List<Book> bookList = BookManager.bookList;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(scanner.nextLine())){
                System.out.println(BookManager.updateBook(bookList.get(i))?"Cap nhat thanh cong": "Sach khong ton tai");;
                break;
            }
        }
    }

    private static void addData(Scanner scanner) {
        System.out.println("Nhap so sach muon them");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Book newBook = new Book();
            newBook.inputData();
            BookManager.addBook(newBook);
        }
    }
}
