package bai4;

import java.io.*;
import java.util.Arrays;

public class Bai4 {
    /*Đề bài: Viết chương trình đọc nội dung từ file text và tạo một bản sao của file đó với tên mới và các từ được đảo ngược thứ tự.
Hướng dẫn làm bài:
-	B1: tạo file gốc và nhập văn bản
-	B2: đọc văn bản thành string
-	B3: convert string thành mảng string với mỗi string là 1 từ.
-	B4: đảo ngược mảng string và đổi lại thành 1 string  = 1 vòng lặp
-	B5: ghi ra file mới.

*/
    public static void main(String[] args)   {
        File sourceFile = new File("./src/bai4/sourceFile");
        try {// check file đã tồn tại chưa
            if (!sourceFile.exists()){
                sourceFile.createNewFile();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        reverseFile(sourceFile,"./src/bai4/targetFile");
    }

    public static void reverseFile(File sourceFile, String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // lấy chuỗi từ file
        StringBuilder inputString = getStringBuilder(sourceFile);
        // đảo ngc string
        String reverseString = inputString.reverse().toString();
        //từ string thành mảng các string
        String[] arr = reverseString.split(" ");
        //ghi lại file
        updateFile(file, arr);
    }

    private static void updateFile(File file, String[] arr) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i]);
                fw.write(" ");// tạo khoảng cách cho mỗi ptu
                fw.flush();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder getStringBuilder(File sourceFile) {
        StringBuilder inputString = new StringBuilder();// tạo stringbuilder
        FileReader fr = null;
        BufferedReader br = null;
        try {//đọc file và cho stringbuilder lấy string theo dòng
            fr = new FileReader(sourceFile);
            br = new BufferedReader(fr);
            String c;
            while ((c = br.readLine()) != null) {
                inputString.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr !=null){
                    fr.close();
                }
                if (br!=null){
                    br.close();
                }
            } catch (IOException e){
                throw new RuntimeException();
            }
        }
        return inputString;
    }
}
