
package APP;


import java.io.IOException;

public class TestFinally{
    
 

    public static void main(String[] args) throws IOException {
     
            System.out.println("entrer votre code ");

        try
        {
            int x =   System.in.read();
            System.out.println("Block dans try ");
        }

        catch(IOException ex)
        {
            System.out.println("Exception trouver in catch block");
        }

        finally
        {
            System.out.println("Merci de votre visite");
        }
    }

}


