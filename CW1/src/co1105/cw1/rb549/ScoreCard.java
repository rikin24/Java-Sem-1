package co1105.cw1.rb549;

public class ScoreCard {
    private final String theName;
    private final Course theCourse;
    private final double theTime;
    private int[] theScores;
    // Creates private variables that can only be accessed by this class

    public ScoreCard(String pName, Course course, double time, int[] scores) {
        theName = pName;
        theCourse = course;
        theTime = time;
        theScores = scores;
        // Creates variables based on the parameters
    }

    public String getName() {
        return theName;
        // Function returns the player name
    }

    public double getRawTime() {
        return theTime;
        // Function returns the raw total time the player took on the course
    }

    public int[] getScores() {
        for(int i = 0; i < theScores.length; i++){
            theScores[i] -= theCourse.getHolePar(i);
        }
        return theScores;
        // Returns scores that are calculated by subtracting the original scores from the hole pars
    }

    public double getAdjustedTime() {
        double sum = 0;
        for(int i = 0; i < theScores.length; i++){
            sum += theScores[i];
        }
        double totalSum = theCourse.getCoursePar() + theTime + sum;
        return totalSum;
        // Calculates and returns adjusted time for each player
    }

    public String toString() {
        getScores();
        String baseString = "";
        for(int i = 0; i < theScores.length; i++) {
            baseString += String.format("%3s", theScores[i]);
        }
        String output = String.format("%8s", getName()) + " (" + getRawTime() + ")" + baseString + "  AdjustedTime: " + String.format("%3s", getAdjustedTime());
        return output;
        // Returns each players details including name, time, score and adjusted time
    }
}
