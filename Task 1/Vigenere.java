import javax.swing.JOptionPane;

/**
 * Encrypts and Decrypts messages with passwords based on the Vigenere Cipher
 * @date October 1, 2017
 * @author Julia McDonald
 */
public class Vigenere implements Encryptable{
  //instance variables
  public String msg;
  public String password;
  public boolean encrypted;
  
  /**
   * Constructor: Stores the original message after turning it into all uppercase without spaces.
   * @param msg - the plain message
   * @param password - the encryption password
   */
  public Vigenere( String msg, String password ){
    this.msg = msg.toUpperCase().replaceAll( "\\s","" );
    this.password = password.toUpperCase();
    encrypted = false;
  }
  
  /**
   * Encrypts this secret using a Vigenere cipher. Has no effect if this secret is already encrypted.
   */
  public void encrypt(){
    if( encrypted ){//an encrypted msg should not be encrypted again
      JOptionPane.showMessageDialog( null, "Your message has already been encrypted." );
      return;
    }
    
    String tempMsg = "";
    int[] shifts = findShift();
    
    //i is index in msg, j is index in shift array
    for( int i = 0, j = 0; i < msg.length(); i++, j++ ){
      if( j >= shifts.length )
        j = 0;
      //wrap the alphabet
      if( msg.charAt( i ) + shifts[ j ] > 'Z' ){
        tempMsg += (char)(msg.charAt( i ) + shifts[ j ] - 26 );
      }
      else{
      tempMsg += (char)( msg.charAt( i ) + shifts[ j ] );
      }
    }
    
    msg = tempMsg;
    
    encrypted = true;
  }
  
  
  /**
   * Finds the alphabetical position of each character in the password and creates an array
   * with the values
   * @return ordered shifts for each character in the msg
   */
  private int[] findShift(){
    int[] shifts = new int[ password.length() ];
    for( int i = 0; i < password.length(); i++ ){
      shifts[ i ] = (int)( password.charAt( i ) - 'A' );
    }
    return shifts;
  }
  
  /**
   * Decrypts and returns this secret. Has no effect if this secret is not currently encrypted.
   * @return the secret message
   */
  public String decrypt(){
    if( !encrypted ){
      JOptionPane.showMessageDialog( null, "Your message has already been decrypted." );
      return msg;
    }
    
    String tempMsg = "";
    int[] shifts = findShift();
    
    //i is index in msg, j is index in shift array
    for( int i = 0, j = 0; i < msg.length(); i++, j++ ){
      if( j >= shifts.length )
        j = 0;
      //wrap the alphabet
      if( msg.charAt( i ) - shifts[ j ] < 'A' ){
        tempMsg += (char)( msg.charAt( i ) - shifts[ j ] + 26 );
      }
      else{
      tempMsg += (char)( msg.charAt( i ) - shifts[ j ] );
      }
    }
    
    msg = tempMsg;
    
    encrypted = false;
    
    
    return msg;
  }
  
  /**
   * Returns true if this secret is currently encrypted.
   * @return encryption status
   */
  public boolean isEncrypted(){
    return encrypted;
  }
  
  /**
   * Returns this secret (may be encrypted).
   * @return the secret
   */
  public String toString(){
    return msg;
  }
}