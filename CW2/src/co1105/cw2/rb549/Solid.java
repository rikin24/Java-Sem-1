package co1105.cw2.rb549;

import java.lang.Comparable;
/**
 * Abstract class to represent Solids.
 */
abstract class Solid implements Comparable<Solid> {
    // Some attributes/methods are missing
    abstract public boolean equals (Object other);
    abstract public int hashCode();
    abstract public String toString();

    protected static int solidCount;
    protected final int solidID;

    public int compareTo (Solid other) {
        // You need to complete this method so that it compares Solids by
        // surface area
        return 0;
    }

    public Solid() {
        solidID = ++solidCount;
    }

    public int getID() {
        return solidID;
    }

    public abstract double getSurface();

    public abstract double getVolume();



}