package GUI;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author Abdelaziz
 */
public class MyException extends Exception implements Serializable {

    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "My Exception";
    }

    public boolean checkPositive(String x) {
        int number=Integer.parseInt(x);
            if (number < 0) 
                return false;
            return true;
    }

    public String checkEmail(String x,String p) {
        String email = x;
        do { if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(null, "Not valid Input for Email Try Again ");
               email = JOptionPane.showInputDialog("Enter Valid input for " + p + " !");
        }
        } while (!email.contains("@") || !email.contains("."));
        return email;
    }
    public String checkPassLength(String x,String p) {
        String pass = x;

        do {    if (pass.length() < 8){
                JOptionPane.showMessageDialog(null, "Not valid Password length Try Again ");
                pass = JOptionPane.showInputDialog("Enter more than 8 char for " + p + " !");
            }
        } while (pass.length() < 8);
        return pass;
    }
    
    
    
    public boolean ISnumeric(String p)
    {
        int number=0;

            boolean b=true;
        
        try
            {
           number = Integer.parseInt(p);
           b=true;
           }
            catch (NumberFormatException e) 
            {
            b=false;
                System.out.println(e); 
        }
        return b;
    }
}
