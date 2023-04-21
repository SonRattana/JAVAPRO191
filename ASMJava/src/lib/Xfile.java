/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import Model.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SON RATTANA
 */
public class Xfile {

    //byte dung write outputstream
    //ham write file
    public static void writeFile(String path) {
        File f = new File(path);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            byte[] arr = {10, 20, 30}; // ghi so gi cung dc
            fos.write(arr);
            fos.close(); // bam do bong den chon catch founds
        } catch (FileNotFoundException e) { // do dong 33 sinh ra
            System.err.println("File not found");
        } catch (IOException ex) { // bat loi read khong dc write khong dc (dong nay do dong 37 sinh ra)
            System.err.println("Failed");
        }
    }

    //ham read file
    public static void readFile(String path) {
        File f = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            int fileSize = (int) f.length(); //ep kieu tuong minh
            byte[] arr = new byte[fileSize];
            fis.read(arr);
            for (int i = 0; i < fileSize; i++) {
                System.out.println(arr[i] + " ");
            }
            fis.close(); // bam do bong den chon catch founds
        } catch (FileNotFoundException e) { // do dong 23 sinh ra
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Failed");
        }
    }

    public static void writeDataFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos); // biet thanh dataoutputstream
            dos.writeInt(5);
            dos.writeUTF("Na");
            dos.writeDouble(8.7);
            dos.close();
        } catch (IOException e) {
            System.err.println("Failed");
        }
    }

    public static void readDataFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readDouble());
            dis.close();
        } catch (IOException e) {
            System.out.println("Failed");
        }
    }
    //char

    public static void writeBuffer(String path, String text) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.err.println("Failed");
        }
    }

    public static String readBuffer(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String firstLine = br.readLine();
            while (firstLine != null) {
                sb.append(firstLine);
                firstLine = br.readLine();//nextLine
                if (firstLine != null) {
                    sb.append("/n");
                }
            }
        } catch (IOException e) {
            System.err.println("Failed");
        }
        return sb.toString();
    }

    public static void writeObject(String path, Object o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(path)
            );
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(path)
            );
            Object o = ois.readObject();
            ois.close();
            return o;
        } catch (IOException e) {
            System.err.println("Failed");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found");
        }
        return null;
    }

    public static void main(String[] args) {
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("admin", "123456"));
        String filepath = "./src/lib/account.dat";
        writeObject(filepath, userlist);
    }
}
