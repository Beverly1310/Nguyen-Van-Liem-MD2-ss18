package bai8;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private int id;
    private String nameProduct;
    private String nsx;
    private double price;
    private String description;

    public Product() {
    }

    public Product(int id, String nameProduct, String nsx, double price, String description) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.nsx = nsx;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", nsx='" + nsx + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Id sp");
        this.id=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten sp: ");
        this.nameProduct=scanner.nextLine();
        System.out.println("Nhap nsx");
        this.nsx=scanner.nextLine();
        System.out.println("Nhap gia");
        this.price=Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap mo ta");
        this.description=scanner.nextLine();

    }
}
