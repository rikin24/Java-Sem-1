package co1105.cw1.rb549;

public class Tournament {
    private final Course course;
    private final ScoreCard[] scores;
    // Creates private variables that can only be accessed by this class

    public Tournament(Course theCourse, ScoreCard[] theScores) {
        course = theCourse;
        scores = theScores;
        // Creates variables based on the parameters
    }

    public String toString() {
        String line = course.toString() + "\n";
        for(int i = 0; i < scores.length; i++) {
            line += scores[i].toString() + "\n";
        }
        return line;
        // Converts all course data into string format and returns it
    }

    public String declareWinner() {
        double total = 1000.0;
        String finalString = "";
        for(int i = 0; i < scores.length; i++){
            if (scores[i].getAdjustedTime() < total){
                total = scores[i].getAdjustedTime();
                finalString = scores[i].getName();
            }
        }
        // Calculates the winner by finding the player with the lowest adjusted time
        String output = ("Winner is " + finalString);
        return output;
        // Returns an output displaying the winner
    }
}
