/*
 * FILENAME: School.java
 * WHO: Julia McDonald, Xinhui Xu
 * WHEN: Sept. 16, 2017
 * WHAT: Assignment 4 Task 3 Defines a class of School objects that store information about individual grad schools
 */
public class School{

  //constants
  private final int MAX = 10;
  private final int MIN = 1;
  
  //instance variables
  private String name;
  private int academics;
  private int research;
  private int pubs;
  private int rating;
  private int rank_value;
  
  /*Initializes a school object, and enforces all values to be within MIN and MAX.
   * @param name - The school name
   * @param academics - Rating of academics
   * @param research - Rating of educating research scholars
   * @param pubs - Rating of impact of faculty publications
   */  
  public School(String name, int academics, int research, int pubs){
    if( academics <= MAX && academics >= MIN && 
       research <= MAX && research >= MIN &&
       pubs <= MAX && pubs >= MIN){
      this.name = name;
      this.academics = academics;
      this.research = research;
      this.pubs = pubs;
      
    }
    else{
      System.out.println( "Invalid Input" );
    }
  }
  
  /*Returns a formatted string of the instance values.
   * @return - the information of the school
*/
  public String toString(){
    return ( "Name: " + name + "\nAcademics: " + academics + 
            "\nResearch: " + research + "\nPublications: " + pubs 
           + "\nOverall rating: " + rating + "\nCurrent rank: " + rank_value + "\n" );
  }
  
  /*Gets the school name
   * @return - the school name*/
  public String getName(){
    return name;
  }
  /*gets the academics rating
   * @return - the academics rating*/  
  public int getRateAcademics(){
    return academics;
  }
  /*gets the research rating
   * @return - the research rating*/
  public int getRateResearch(){
    return research;
  }
    /*gets the publications rating
   * @return - the publications rating*/
  public int getRatePubs(){
    return pubs;
  }
    /*gets the overall rating
   * @return - the overall rating*/
  public int getOverallRating(){
    return rating;
  }
  
    /*gets the rank value
   * @return - the rank value*/
  public int getRankValue(){
    return rank_value;
  }
  /*Since the assignment wants a synonym for the OverallRating setter, we just call it
   * @param acad_weight - weight of academics
   * @param research_weight - weight of research
   * @param pub_weight - weight of publications
   */
  public void computeRating(int acad_weight, int research_weight, int pub_weight){
     setOverallRating( acad_weight, research_weight, pub_weight );
  }
  
  /*sets a value to the school name
   * @param - the new school name*/
  public void setName(String newName){
    name = newName;
  }
    /*Computes overallRating for a School that considers all factors, given input weights for the individual factors.
Note that all weights have to be in the range of [1,5].
   * @param acad_weight - weight of academics
   * @param research_weight - weight of research
   * @param pub_weight - weight of publications*/
  public void setOverallRating(int acad_weight, int research_weight, int pub_weight){
    if ( (1 <= acad_weight) && (acad_weight <= 5) &&
        (1 <= research_weight) && (research_weight <= 5) &&
        (1 <= pub_weight) && (pub_weight <= 5))
      rating = acad_weight * academics +
      research_weight * research +
      pub_weight * pubs; 
  }
  
  /* sets a value to the school rank
   * @param - the school rank*/
  public void setRankValue( int newValue ){
    rank_value = newValue;
  }
    /* sets a value to the academics rate
   * @param - the academics rate*/
  public void  setRateAcademics(int newRate)  {
    academics = newRate;
  }
    /* sets a value to the publications rate
   * @param - the pub rate*/
  public void setRatePubs(int newRate) {
    pubs = newRate; 
  }
    /* sets a value to the research rate
   * @param - the research rate*/
  public void setRateResearch(int newRate){
    research = newRate;
  }
 /*
  * Driver method to test this class
  */
  public static void main(String [] args){
    School wellesley = new School("wellesley", 10, 6, 4 );
    System.out.println( wellesley +"\n");
    
    School harvard = new School( "harvard", 1, 1, 1 );
    System.out.println( harvard );
    harvard.computeRating(1, 1, 5);
    System.out.println("Computed rating: " + harvard.getOverallRating());
  }
  
}