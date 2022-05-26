package co1105.cw2.rb549;

public class Cuboid extends Solid {
    public int height;
    public int width;
    public int length;

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        String output = "Cuboid " + getID() + ": " + height + "x" + width + "x" + length;
        return output;
    }

    public Cuboid(int h, int w, int l) throws InvalidSolidException {
        height = h;
        width = w;
        length = l;
        if (h <= 0 || w <= 0 || l <= 0) {
            throw new InvalidSolidException("All dimensions must be > 0");
        }
    }

    public Cuboid(Cuboid other) {
        height = other.height;
        width = other.width;
        length = other.length;
    }

    public double getSurface() {
        double sa = height * width * 2 + height * length * 2 + width * length * 2;
        return sa;
    }

    public double getVolume() {
        double volume = height * width * length;
        return volume;
    }
}