/**
 * A simple Webpage object, keeps track of the webpage's URL, the number of lines
 * in the webpage and its contents (or part of it).
 * @date October 1, 2017
 * @author Julia McDonald
 */
public class Webpage implements Comparable< Webpage >{
  //instance variables
  public String URLname;
  public int lineCounter;
  public String pageContent;
  
  /**
   * Constructs a new Webpage object.
   * 
   * @param URLname - the URL of the webpage
   * @param lineCounter - number of lines in the page content
   * @param pageContent - the page content
   */
  public Webpage( String URLname, int lineCounter, String pageContent ){
    this.URLname = URLname;
    this.lineCounter = lineCounter;
    this.pageContent = pageContent;
  }
  
  /**
   * Getter to return the URL name of this object
   * @return the URL of the page
   */
  public String getURLName(){
    return URLname;
  }
  
  /**
   * Getter to return the line counter for this page
   * @return the number of lines in the page content
   */
  public int getLineCounter(){
    return lineCounter;
  }
  
  /**
   * Getter to return the page content of this object
   * @return the page content
   */
  public String getPageContent(){
    return pageContent;
  }
  
  /**
   * Setter to set the URL name
   * @param name - webpage URL name
   */
  public void setURLName( String name ){
    URLname = name;
  }
  
  /**
   * Setter to set the line counter
   * @param value - the number of lines in the page content
   */
  public void setLineCounter(int value){
    lineCounter = value;
  }
  
  /**
   * Setter to set the page content
   * @param content - the page HTML content
   */
  public void setPageContent( String content ){
    pageContent = content;
  }
  
  /**
   * Returns a String representation of this object, with the first 20 characters of 
   * the page's HTML content
   * @return a nicely formatted string for the page object
   */
  public String toString(){
    String content;
    if( pageContent.length() >= 20 )
      content = pageContent.substring( 0, 20 );
    else
      content = pageContent;
    return URLname + " : " + lineCounter + " : " + content + "...";
  }
  
  /**
   * Uses the number of lines in the webpage as the comparator. 
   * Returns -1 if this Webpage is less than the specified Webpage p. 
   * Returns 1 if this Webpage is greater than the specified Webpage p. 
   * Returns 0 if the two Webpages are equal.
   * 
   * @param p - the other page object to compare against
   * @return comparison result
   */
  public int compareTo(Webpage p){
    if( lineCounter < p.lineCounter )
      return -1;
    if( lineCounter == p.lineCounter )
      return 0;
    return 1;
  }
  
  /**
   * main method to test the class
   */
  public static void main( String[] args ){
    Webpage google = new Webpage( "http://www.google.com", 8, "please enter a search here" );
    
    System.out.println( google.getURLName() + "\n" + google.getLineCounter() + "\n" + 
                       google.getPageContent() + "\n");
    
    google.setURLName( "google.com" );
    google.setLineCounter( 5 );
    google.setPageContent( "Search the world's information, including webpages, images" );
    
    System.out.println( google );
    
    Webpage netflix = new Webpage( "netflix.com", 42, "Watch movies and tv shows from your living room" );
    System.out.println( netflix );
    
    System.out.println( google.compareTo( netflix ));
  }
}