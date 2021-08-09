/*3 Parts to a GUI Apllication
   1. Building the GUI Components
   2. Providing the Listener Methods
   3. Developing the Application Code/Methods
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calc extends JFrame implements ItemListener
{
   JLabel lnum1, lnum2;
   JTextField tnum1, tnum2, tres;
   JComboBox cboOptrs;
   String optrs[] = {"+", "-", "*", "/"};
   int num1, num2, res;
   Container c = getContentPane();
   
   public Calc() //1. GUI Components through the constructor
   {
      super("Simple Calculator v1.0");
      
      lnum1 = new JLabel("Input 1st number: ");
      lnum2 = new JLabel("Input 2nd number: ");
      
      tnum1 = new JTextField(10);
      tnum2 = new JTextField(10);
      tres = new JTextField(10); tres.setEditable(false);
      
      cboOptrs = new JComboBox(optrs); cboOptrs.addItemListener(this); //registers the listener for the cbo
      c.setLayout(new GridLayout(3,2));
      c.add(lnum1); c.add(tnum1);
      c.add(lnum2); c.add(tnum2);
      c.add(cboOptrs); c.add(tres);
      
      setSize(300, 200);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
      
   }
   
   //2. Provide Listener Methods
   public void itemStateChanged(ItemEvent e) //override the method in ItemListener
   {
      try{
         num1 = Integer.parseInt(tnum1.getText());
         num2 = Integer.parseInt(tnum2.getText());
      
         if(cboOptrs.getSelectedIndex()==0)
            res = add();
         else if(cboOptrs.getSelectedIndex()==1)
            res = subtract();
         else if(cboOptrs.getSelectedIndex()==2)
            res = multiply();
         else if(cboOptrs.getSelectedIndex()==3)
            res = divide();
      
         tres.setText(res+"");
      }
      catch(ArithmeticException ae){
         tres.setText("Div0 Error");
      }  
      catch(NumberFormatException nfe){
         tres.setText("Invalid input!");
      }   
   }
   
   //3. Application Code/Methods
   public int add(){
      return num1 + num2;
   }
   public int subtract(){
      return num1 - num2;
   }
   public int multiply(){
      return num1 * num2;
   }
   public int divide(){
      return num1 / num2;
   }
}

//-------------------------------------------
public class CalcDemo
{
   public static void main(String args[])
   {
      new Calc();
   }
}