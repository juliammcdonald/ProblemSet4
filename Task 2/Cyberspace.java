import java.net.*;
import java.util.*;
import java.io.*;
  
/**
 * Creates a list of webpage objects, sorts them by number of lines,
 */
public class Cyberspace{
  public ArrayList< Webpage > sites;
  
  /*
   * 
   */
  public Cyberspace(){
    sites = new ArrayList< Webpage>();
  }
  
  /**
   * fetches contents of page, calls count lines, stores in webpage object
   * adds new webpages so that they are sorted from least lines to most lines
   * @param URLname - the URL of the webpage to be added
   */
  public void addWebpage( String URLname ){
    try{
      InputStream source = new URL( URLname ).openStream();
      Scanner scan = new Scanner( source );
      
      Webpage web = new Webpage( URLname, 0, "" );
      
      int lineCount = 0;
      while( scan.hasNextLine() ){
        lineCount++;
        web.setPageContent( web.getPageContent() + scan.nextLine() );
      }
      web.setLineCounter( lineCount );
      
      if( sites.size() > 0 ){
        for( int i = 0; i < sites.size(); i++ ){
          //inserts the element into the arraylist when it finds the first webpage that 
          //has more lines
          if( web.compareTo( sites.get( i ) ) <= 0 ){
            sites.add( i, web );
            break;
          }
        }
        if( !sites.contains( web )){
          sites.add( web );
        }
      } else {
        sites.add( web );
      }
    } catch( IOException ex ){
      System.out.println( ex );
    }
      
  }
  
  /**
   * Creates a string of the webpages' URLs, their line counters, and the first 20 characters 
   * of their contents, from the sorted collection.
   * 
   * @return a nicely formatted list of Webpage objects
   */
  public String toString(){
    String str = "Results from visiting " + sites.size() + " pages\n";
    
    for( int i = 0; i < sites.size(); i++ ){
      str += sites.get( i ) + "\n";
    }
    return str;
  }
  
  /**
   * Adds all webpages from a file
   * @param fileName - the name of the file to be read from
   * @return a Cyberspace object containing webpages in file
   */
  private static Cyberspace addFromFile( String fileName ){
    try{
      Scanner scan = new Scanner( new File( fileName ));
      
      Cyberspace pages = new Cyberspace();
      
      while( scan.hasNextLine() ){
        pages.addWebpage( scan.nextLine() );
      }
      
      scan.close();
      return pages;
    } catch( IOException ex ) {
      System.out.println( ex );
    }
    return new Cyberspace();
  }
  
  /**
   * Adds all webpages from keyboard input
   * @return a Cyberspace object containing webpages entered
   */
  public static Cyberspace addFromKeyboard(){
    System.out.println( "Please enter URLs (without spaces) below. End your list with ctrl-D:" );
    Scanner scan = new Scanner( System.in );
    
    Cyberspace pages = new Cyberspace();
    
    while( scan.hasNextLine() ){
      pages.addWebpage( scan.nextLine() );
    }
    
    scan.close();
    return pages;
  }
  
  /**
   * Driver method for the class
   */
  public static void main( String[] args ){
    Cyberspace pages;
    
    if( args.length > 0 ){
      //read from file
      pages = addFromFile( args[ 0 ] );
    } else {
      //read from keyboard
      pages = addFromKeyboard();
    }
    System.out.println( pages );
  }
}