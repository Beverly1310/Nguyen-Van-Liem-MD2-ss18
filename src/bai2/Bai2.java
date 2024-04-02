package bai2;

import java.io.*;
import java.util.Arrays;

public class Bai2 {
    /*Viết một chương trình cho phép người dùng sao chép các tập tin.
    Người sử dụng cần phải cung cấp một tập tin nguồn (source file) và một tập tin đích (target file).
Chương trình sao chép tệp nguồn vào tệp tin đích và hiển thị số byte trong tệp.
Chương trình nên cảnh báo người dùng nếu tệp nguồn không tồn tại hoặc nếu tập tin đích đã tồn tại.
Để sao chép nội dung từ tệp tin nguồn đến tệp tin đích, bạn nên sử dụng luồng đầu vào để đọc byte từ tệp nguồn và luồng đầu ra để gửi byte đến tệp tin đích, bất kể nội dung của tệp.
*/
    public static void main(String[] args) {
        File sourceFile = new File("./src/bai2/sourceFile");
        try {// check tồn tại
            if (!sourceFile.exists()){
                sourceFile.createNewFile();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File targetFile = new File("./src/bai2/targetFile");
        try {// check tồn tại
            if (!targetFile.exists()){
                targetFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("So byte: "+copyFile(sourceFile,targetFile));
        String str = "Viết chương trình đọc nội dung từ file text và hiển thị số lượng từ trong file đó";
        System.out.println(str.getBytes().length);
    }

    public static int copyFile(File sourceFile, File targetFile) {
        if (!sourceFile.exists() || targetFile.length()>0) {// ktra file nguồn có tồn tại chưa hoạc file đích đã tồn tại r
            throw new RuntimeException();
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int byteCount ;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
           int c;
           byteCount = 0;
           //đọ từ file nguồn và ghi lại vào file đich
            while ((c = bis.read()) != -1 ) {
                bos.write(c);
                bos.flush();// đẩy từ bôj nhớ đệm ra file đích
                byteCount++;// số byte +1
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
   try {
       if (fis!=null){
           fis.close();
       }
       if (fos!=null){
           fos.close();
       }
   } catch (IOException e) {
       throw new RuntimeException(e);
   }
        }
        return byteCount;
    }
}

