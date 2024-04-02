package bai6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bai6 {
    public static void main(String[] args) {
        //đọc
        BufferedReader br;
        try {//tạo dtg buferreader
            br = new BufferedReader(new FileReader("./src/bai6/source.text"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }//tạo hash map
        HashMap<String, Integer> countMap = new HashMap<>();
        int c;
        // tạo dtg stringbuilder
        StringBuilder str = new StringBuilder();
        try {
            while ((c = br.read())!=-1){
                str.append((char) c);// cho stringbuilder apened từng ký tự
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String[] arrStr = str.toString().split(" ");//từ string builder thành mảng các từ
        for (int i = 0; i < arrStr.length; i++) {// duyệt mảng
            if (countMap.containsKey(arrStr[i])){//kiểu tra, nếu key tồn tại value +1, nếu chua value =1
                countMap.put(arrStr[i],countMap.get(arrStr[i])+1);
            } else {
                countMap.put(arrStr[i],1);
            }
        }
        String maxKey = null;// cho maxkey = null và value = gtri nhỏ nhất
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {// duyệt đểt tìm key có value lơn nhất bằng entryset
            if (entry.getValue()>maxValue){
                maxKey=entry.getKey();
                maxValue=entry.getValue();
            }
        }
        System.out.println("Tu xuat hien nhieu nhat la: "+maxKey+" ||so lan xuat hien: "+maxValue);
    }
}
