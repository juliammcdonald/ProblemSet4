/*
 * FILENAME: GradSchools.java
 * WHO: Julia McDonald, Xinhui Xu
 * WHEN: Oct. 1, 2017
 * WHAT: Assignment 4 Task 3 Defines a class for maintaining a collection of School objects
 */
public class GradSchools{
  
  //instance variables
  private School[] schools;
  private int numGradSchools;
  private boolean ranked;
  private static int academicsWeight;
  private static int researchWeight;
  private static int pubsWeight;
  
  /**
   *  Initializes the instance variables of the collection, given an initial collection size.
   */
  public GradSchools(int numSchoolSlots){ 
    schools = new School[ numSchoolSlots ]; // initiates null array of length numschools
    ranked = false;
    numGradSchools = 0;
  }
  
 /**
   * Initializes the instance variables of the collection
   */
  public GradSchools(){
    schools = new School[10];
    ranked = false;
    numGradSchools = 0;
  }
  /**
   * Adds a new School object to the collection.
   * @param newSchool - the new school to be added
   */
  public void addSchool(School newSchool){ 
    for (int i = 0; i < schools.length; i++){
      if (schools[i] == null ||
          schools[i].getName().equalsIgnoreCase(newSchool.getName())){
        schools[i] = newSchool;
        numGradSchools++;
        return;
      }
    }
    System.out.println("not enough space");
  }
  
  /**
   * Computes overallRating for each School object.
   * @param acad_weight - weight of academics
   * @param research_weight - weight of research
   * @param pub_weight - weight of publications
   */
  public void computeRatings(int acad_weight, int research_weight, int pub_weight){
    for (int i = 0; i < schools.length; i++){
      if (schools[i] != null ){
        schools[i].computeRating(acad_weight, research_weight, pub_weight);
      }
    }
  }
  
  /**
   * Returns a formatted string of the instance values.
   * @return The schools in the collection
   */
  public String toString(){
    String ret = "There are " + numGradSchools + " schools in the database:\n";
    for (int i = 0; i < schools.length; i++){
      if (schools[i] != null){
        ret += schools[i] + "\n\n";
      }
    }
    return ret;
  }
  
  /**
   *   Rank orders the School objects in the schools array, either by a 
   *  single factor or the overallRating as specified by an input String, and 
   * prints the names of the schools in order from highest to lowest rank
   * 
   * @param factor - The factor to consider in the ranking ["Academics", "Research", "Publications", "Overall"]
   */
  public void rankSchools( String factor ){
    int[] rankings = new int[ schools.length ];
    
    if( factor.equalsIgnoreCase( "Academics" )){
      for( int i = 0; i < schools.length; i++ ){
        if (schools[i] != null){
          schools[ i ].setRankValue( schools[ i ].getRateAcademics() );
          rankings[ i ] = schools[ i ].getRankValue();
        }
      }
    } else if ( factor.equalsIgnoreCase( "Research" )){
      for( int i = 0; i < schools.length; i++ ){
        if (schools[i] != null){
          schools[ i ].setRankValue( schools[ i ].getRateResearch() );
          rankings[ i ] = schools[ i ].getRankValue();
        }
      }
    } else if (factor.equalsIgnoreCase( "Publications" )){
      for( int i = 0; i < schools.length; i++ ){
        if (schools[i] != null){
          schools[ i ].setRankValue( schools[ i ].getRatePubs() );
          rankings[ i ] = schools[ i ].getRankValue();
        }
      }
    } else if (factor.equalsIgnoreCase( "Overall" )){
      computeRatings( academicsWeight, researchWeight, pubsWeight );
      for( int i = 0; i < schools.length; i++ ){
        if (schools[i] != null){
          schools[ i ].setRankValue( schools[ i ].getOverallRating() );
          rankings[ i ] = schools[ i ].getRankValue();
        }
      }
    } else {
      ranked = false;
      return;
    }

    Sort.sortArrayDec( rankings );      

    School[] temp = new School[schools.length];
    
    //schools are matched with their ranking, and then that ranking value in the 
    //ranking array is changed to 0 so that no other school can be paired with it
    for( int j = 0; j < schools.length; j++ ){
      for( int i = 0; i<rankings.length; i++){ 
          if ((schools[j] != null) && 
              (schools[j].getRankValue() == rankings[i])) {
            temp[i] = schools[j];
            rankings[ i ] = 0;
            break;
        }
      }
    }
      
    for( int i = 0; i< schools.length; i++ ){
      schools[i] = temp[i];
    }
    
    ranked = true;
  }
  
  
  /**
   * Displays the rank results.
   * @param factor - The factor to consider in the ranking ["Academics", "Research", "Publications", "Overall"]
   */
  public void displayRankResults( String factor ){
    rankSchools( factor );
    if( ranked ){
      System.out.println( "Ranking of schools from highest to lowest using " + factor + " as a factor:" );
      for( int i = 0; i < schools.length; i++ ){
        if( schools[ i ] != null ){
          System.out.println( schools[ i ].getName());
        }
      }
      System.out.println();
    }
    else{
      System.out.println( "Invalid factor" );
    }
  }
  
  /**
   * Returns the last School in the collection. 
   * When sorted, this should be the one with the maximum rank (the "top" school) in this category.
   * @return - The top school in the ranking 
   */
  public School getTop(){
    return schools[0]; 
  }
  
  /**
   * Driver code for testing the methods defined in the GradSchools class for maintaining an array of School objects
   */
  public static void main(String [] args){
    if (args.length != 3) {
      System.out.println("Please provide 3 weights (1..5) for Academics, Research, and Publications.");
    } else {
      academicsWeight = Integer.parseInt(args[0]);
      researchWeight = Integer.parseInt(args[1]);
      pubsWeight = Integer.parseInt(args[2]);
      
      School Berkeley = new School("UC Berkeley", 9, 9, 9);
      School Stanford = new School("Stanford", 8, 10, 9);
      School CMU = new School("CMU", 7, 8, 6);
      School MIT = new School("MIT", 10, 10, 7);
      
      GradSchools myGrads = new GradSchools();
      myGrads.addSchool(Berkeley);
      myGrads.addSchool(Stanford);
      myGrads.addSchool(MIT);
      myGrads.addSchool(CMU);
      
      myGrads.computeRatings(academicsWeight, researchWeight, pubsWeight);
      
      System.out.println(myGrads);
      
      myGrads.displayRankResults( "Academics" );
      System.out.println(myGrads);
      myGrads.displayRankResults( "Research" );
      myGrads.displayRankResults( "publications" );
      myGrads.displayRankResults( "overall" );
    }
    
    
  }
  
}