package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai1 {
    /*Đề bài: Viết chương trình đọc nội dung từ file text và hiển thị số lượng từ trong file đó.
Hướng dẫn:
-	B1: tạo file text có sẵn dữ liệu văn bản (data có thể là đề bài này)
-	B2: Tạo hàm đọc file trên và trả ra String.
-	B3: convert String ở bước 2 thành mảng string, mỗi từ là 1 phần tử
-	B4: length của mảng trên chính là số lượng từ trong file.
 */
    public static void main(String[] args) throws IOException {
        File file = new File("./src/bai1/bai1.txt");
        if (!file.exists()){//check tồn tại
            file.createNewFile();
        }
        String inputString = readFile("./src/bai1/bai1.txt");// lấy dữ liệu từ file
        String[] arrStr = inputString.split(" ");// từ string thành mảng các string
        System.out.println(Arrays.toString(arrStr));// in mảng
        System.out.println("Số lượng ptu: "+ arrStr.length);// in số ptu
        ////////////////bai 3
        List<String> list = new ArrayList<>();// tạo list
        String maxLength = arrStr[0];//maxlength = ptu đầu của mảng
        list.add(maxLength);
        for (int i = 1; i < arrStr.length; i++) {
            if (arrStr[i].length()==maxLength.length()){//ptu có length = maxlength thì thêm vào lít
                list.add(arrStr[i]);
            } else if (arrStr[i].length()>maxLength.length()) {// ptu có length lớn hơn thì xóa líst vào thêm ptu mới vào
                list.clear();
                maxLength = arrStr[i];
                list.add(arrStr[i]);
            }
        }
        System.out.println(list);
    }
    // đọc file
    public static String readFile(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder inputString = new StringBuilder();
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line;
            // đọc file theo dòng và ghi lại vào string builder
            while ((line = br.readLine())!=null){
              inputString.append(line).append("\n");
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return inputString.toString();
    }
}
