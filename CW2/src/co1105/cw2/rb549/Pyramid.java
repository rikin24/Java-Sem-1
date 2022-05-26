package co1105.cw2.rb549;

public class Pyramid extends Solid {
    public int base;
    public int height;

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
        String output = "Pyramid " + getID() + ": " + base + "x" + height;
        return null;
    }

    public Pyramid(int b, int h) throws InvalidSolidException {
        base = b;
        height = h;
        if (b <= 0 || h <= 0) {
            throw new InvalidSolidException("Base and height must be > 0");
        }
    }

    public Pyramid(Pyramid other) {
        base = other.base;
        height = other.height;
    }

    public double getSurface() {
        double sa = base * base + 2 * base * height;
        return sa;
    }

    public double getVolume() {
        double volume = base * base * height / 3.0;
        return volume;
    }
}