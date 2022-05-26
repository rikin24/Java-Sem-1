package co1105.cw1.rb549;

public class Course {
    private final String theCourseName;
    private final int[] theHoles;
    private int coursePar;
    // Creates private variables that can only be accessed by this class

    public Course(String courseName, int[] holes) {
        theCourseName = courseName;
        theHoles = holes;
        // Creates variables based on the parameters
    }

    public String getCourseName() {
        return theCourseName;
        // Function returns course name
    }

    public int getHolePar(int h) {
        return theHoles[h];
        // Function returns the hole pars
    }

    public int getCoursePar() {
        int sum = 0;
        for(int i = 0; i < theHoles.length; i++){
            sum += theHoles[i];
        }
        // Adds all hole pars together
        coursePar = sum;
        return coursePar;
        // Returns total par of all holes
    }

    public String toString() {
        String base = "";
        for(int h : theHoles) {
            base = base + h + "  ";
        }
        base = String.format("%8s", theCourseName) + "         " + base + "Par: " + getCoursePar();
        return base;
        // Returns the name of the course and the total par
    }
}
