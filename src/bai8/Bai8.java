package bai8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        File file = new File("./src/bai8/product.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<Product> productList = new ArrayList<>();
       boolean isExit = false;
       while (!isExit){
           System.out.println("-----------------Menu-----------------");
           System.out.println("1.Them san pham");
           System.out.println("2.Hien thi danh sach san pham");
           System.out.println("3.Tim san pham");
           System.out.println("4. Thoat");
           int choice = Integer.parseInt(scanner.nextLine());
           switch (choice){
               case 1:
                   addProduct(file,productList,scanner);
                   break;
               case 2:
                   displayAll(file);
                   break;
               case 3:
                   findProduct(file,scanner);
                   break;
               case 4:
                   isExit=true;
                   break;
               default:
                   break;
           }
       }
    }
// thêm mới
    public static boolean addProduct(File file, List<Product> productList, Scanner scanner) {
        System.out.println("Nhap so san pham muon them: ");// thêm mới n sản phẩm
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhap thoong tin cho san pham thu: "+(i+1));
            Product newProduct = new Product();
            newProduct.inputData();
            productList.add(newProduct);
        }
        updateFile(file, productList);// cập nhật lại file và list
        return true;
    }
// method ghi đè lại file
    private static void updateFile(File file, List<Product> productList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null){
                    fos.close();
                }
                if (oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
// hiển thị toàn bộ sản phẩm
    public static List<Product> displayAll(File file){
        List<Product> listInput = getProducts(file);//lấy dũ liệu từ file
        for (int i = 0; i < listInput.size(); i++) {
            System.out.println(listInput.get(i).toString());
        }
        return listInput;
    }
// methoad lấy dữ liệu
    private static List<Product> getProducts(File file) {
        List<Product> listInput = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            listInput = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
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
        return listInput;
    }
// tìm sản phẩm
    public static void findProduct(File file,Scanner scanner) {
        int indexProduct = -1;
        List<Product> cloneList = getProducts(file);// lấy dữ liệu sản phẩm
        System.out.println("Nhap ten san pham can tim:");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < cloneList.size(); i++) {
            if (cloneList.get(i).getNameProduct().equals(nameProduct)){
                indexProduct=i;
                break;
            }
        }
        // kiểm tra sản phẩm có tồn tại ko bằng biến index, nếu tồn tại in ra thông tin sp
        if (indexProduct!=-1){
            cloneList.get(indexProduct).toString();
        }
        else {
            System.out.println("San pham khong ton tai");
        }
    }
}
