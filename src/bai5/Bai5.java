package bai5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bai5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try { // tạo buffereader
             br = new BufferedReader(new FileReader("./src/bai5/countries.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String c;
        while ((c = br.readLine())!=null){
            System.out.println(c);//đọc theo dòng
        }
        br.close();
    }
}
