package APP;

import java.io.*;
public class TestExceptions{
    public static void main(String[] args)  {

        //Open the Input file
        File inputFile = new File("Sample.jpg");
        //Open the Output file
        File outputFile1 = new File("Output1.jpg");
        int c1;

        FileInputStream in1 = null;
        FileOutputStream out1 = null;
        try {
            //Get file handlers in Byte Stream format
            in1 = new FileInputStream(inputFile);
            out1 = new FileOutputStream(outputFile1);


            while ((c1 = in1.read()) != -1) {   //Until end of file
                out1.write(c1);
            }


        } catch (IOException e) {
            System.out.println("Nous avons trouver le exception File Not Found Exception");
        } finally {
            System.out.println("travaill parfait");
            //Close the files
          try {
              in1.close();
              out1.close();
          }catch (NullPointerException | IOException e1){
              System.out.println("Nous avons trouver le exception IOException");
          }
        }
    }
}


