package gimovel.dados;

import java.io.*;
import java.text.*;
import java.nio.charset.*;
import java.nio.*;

public class GFile {

    public GFile() {
    }


    public String openFileAsText(String fileName)  {
    try
    {
      // Open a file of the given name.
      File file = new File(fileName);

      BufferedReader br = new BufferedReader(new FileReader(file));

      String str;
      String str2 = "";
     while ((str = br.readLine()) != null) {
         str2 += str + "\n";
     }
     br.close();

     System.out.println(str2);
      return str2;
    }
    catch (IOException e)
    {
        System.out.println(e.getMessage());
      return null;
    }

    }

    /*


     static void teste(){

            try {
                BufferedReader in = new BufferedReader(new FileReader("c:\\saida.txt"));
                String str;
                String str2 = "";
           while ((str = in.readLine()) != null) {
               str2 += str;
           }
           in.close();

           System.out.println(str2);
       } catch (Exception e) {
                      System.out.println(e.getMessage());

      // } catch (IOException ee) {
       //               System.out.println(ee.getMessage());
       }

        }



     */
}


