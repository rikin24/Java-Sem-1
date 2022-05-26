package co1105.cw2.rb549;

public class Sphere extends Solid {
    public int radius;

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return (int) radius;
    }

    @Override
    public String toString() {
        String output = "Sphere " + getID() + ": r=" + radius;
        return output;
    }

    public Sphere(int r) throws InvalidSolidException {
        if (r <= 0) {
            throw new InvalidSolidException("Radius must be > 0");
        }
        this.radius = r;
    }

    public Sphere(Sphere other) {
        this.radius = other.radius;
    }

    public double getSurface() {
        double sa = 4.0 * Math.PI * radius * radius;
        return sa;
    }

    public double getVolume() {
        double volume = 4.0 * Math.PI * radius * radius * radius / 3.0;
        return volume;
    }

}