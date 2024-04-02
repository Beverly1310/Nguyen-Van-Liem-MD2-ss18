package bai9;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPinlisher() {
        return publisher;
    }

    public void setPinlisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten sach:");
        this.title = scanner.nextLine();
        System.out.println("Nhap tac gia:");
        this.author= scanner.nextLine();
        System.out.println("Nhap nha xuat ban:");
        this.publisher= scanner.nextLine();
        System.out.println("Nhap gia:");
        this.price=Double.parseDouble(scanner.nextLine());
    }
}
