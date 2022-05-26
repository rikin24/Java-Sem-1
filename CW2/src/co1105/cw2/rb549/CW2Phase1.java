package co1105.cw2.rb549;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
/**
 * CO1105 (2020/21) CW2 phase 1 test program.
 * <p>
 * Test program that reads a file of Solid specifications and creates
 * a {@link Solid} object for each one of the correct sub-type.
 * <p>
 * For each new Solid, use the {@code toString} method to display it.
 * <p>
 * Finally, display totals for the surface area and volume of all Solids combined.
 * @author Gilbert Laycock
 * @version $Id: CW2Phase1.java 316 2021-02-24 17:07:09Z gtl1 $
 */
class CW2Phase1 {
    /**
     * Main method that reads a file of Solid specifications
     * @param args the name of the file of Solid data should be supplied
     * as the one and only command line argument.
     * @throws InvalidSolidException (Ignore this for phase 1)
     */
    public static void main (final String[] args) throws InvalidSolidException
    // uncomment the above throws
    // once you have completed phase 2
    {
        if (args.length != 1) {
            System.err.println("Usage: java Controller <SolidFile>");
            System.exit(1);
        }
        final String solFile = args[0];
        double totalSurface = 0.0;
        double totalVolume = 0.0;

        // read in the Solids
        try (Scanner sc = new Scanner(new File(solFile))) {
            while (sc.hasNext()) {
                final String[] nextSolids = sc.nextLine().split("\\s");
                final Solid sol;
                switch (nextSolids.length) {
                    case 1:
                        int rad=Integer.parseInt(nextSolids[0]);
                        sol = new Solid.Sphere(rad);
                        break;
                    case 2:
                        int base=Integer.parseInt(nextSolids[0]);
                        int height=Integer.parseInt(nextSolids[1]);
                        sol = new Solid.Pyramid(base,height);
                        break;
                    case 3:
                        int s1=Integer.parseInt(nextSolids[0]);
                        int s2=Integer.parseInt(nextSolids[1]);
                        int s3=Integer.parseInt(nextSolids[2]);
                        sol = new Solid.Cuboid(s1,s2,s3);
                        break;
                    default:
                        System.out.printf("Unknown solid: %s%n",Arrays.toString(nextSolids));
                        sol=null;
                };
                if (sol!=null) {
                    System.out.printf("%s%nS=%3.2f V=%3.2f%n",
                            sol,
                            sol.getSurface(),
                            sol.getVolume());
                    totalSurface += sol.getSurface();
                    totalVolume += sol.getVolume();
                }
            }
        }
        catch (IOException e) {
            System.err.printf("Error reading input file %s%n", solFile);
            e.printStackTrace();
            System.exit(1);
        }

        System.out.printf("Total surface: %3.2f%n",
                totalSurface);
        System.out.printf("Total volume: %3.2f%n",
                totalVolume);

    }
}
