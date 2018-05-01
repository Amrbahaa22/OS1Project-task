///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package task;
//
//import java.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//
///**
// *
// * @author toshiba
// */
//public class Task {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws Exception{
//        try {
//            String name=new String("boby");
//            String pass=new String("1212");
//            ProcessBuilder pb=new ProcessBuilder("sudo -i","m@@dy7alim","useradd",name,"passwrd",pass);
//     pb.redirectErrorStream();
//     Process process=pb.start();
//     InputStream is=process.getInputStream();
//     BufferedReader br=new BufferedReader(new InputStreamReader(is));
//     String line =null;
//     while((line=br.readLine())!=null)
//     {
//         process.waitFor();
//     }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////Process p=Runtime.getRuntime().exec("sudo useradd a7a");
//
//
//       
//}
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author amr-bahaa
 */
public class Task {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Process ls = null;
        BufferedReader input = null;
        String line = null;
        Scanner in=new Scanner(System.in);
        String cin=new String();
        cin=in.next();

       try {

            ls = Runtime.getRuntime().exec("echo 'pass.txt' | more");

            input = new BufferedReader(new InputStreamReader(ls.getInputStream()));

        } catch (IOException e1) {
            e1.printStackTrace();
            System.exit(1);
        }

        try {
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
            System.exit(0);
        }
    }

}
