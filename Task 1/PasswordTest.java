import javax.swing.JOptionPane;
/**
 * Tests Vigenere and runs its GUI dialogue boxes.
 * @date October 1, 2017
 * @author Julia McDonald
 */
public class PasswordTest{
  /**
   * 
   */
  public PasswordTest(){
    int decrypt, again;
    do{
      String msg = JOptionPane.showInputDialog( "What is the message?");
      String pass = JOptionPane.showInputDialog( "What is the password?" );
      
      Vigenere user = new Vigenere( msg, pass );
      
      user.encrypt();
      JOptionPane.showMessageDialog( null, user );
      System.out.println( user );
      
      decrypt = JOptionPane.showConfirmDialog( null, "Do you want it decrypted?" );
      
      if( decrypt == JOptionPane.YES_OPTION ){
        JOptionPane.showMessageDialog( null, user.decrypt() );
        System.out.println( user );
      }else{
        JOptionPane.showMessageDialog( null, "Thanks for encrypting!" );
      }
      
      again = JOptionPane.showConfirmDialog( null, "Would you like to encrypt another message?" );
    } while( again == JOptionPane.YES_OPTION );
  }
  /**
   * Creates a Secret object and a Password object and exercises their encryption.
   */
  public static void main( String[] args ){
    //Vigenere without dialog boxes
    Vigenere attack = new Vigenere( "Attack at Dawn", "CAT" );
    attack.encrypt();
    System.out.println("CTMCCDCTWCWG\n" + attack );
    attack.decrypt();
    System.out.println("ATTACKATDAWN\n" + attack );
    
    //Vigenere with dialog boxes
    PasswordTest dialog = new PasswordTest();
  }
}