package co1105.cw2.rb549;

import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * CO1105 (2020/21) CW2 phase 3 test program.
 * <p>
 * Test program that reads a file of solid geometric shape specifications
 * and creates a {@link Solid} object for each one of the correct sub-type.
 * <p>
 * For each new solid, add it to a {@code TreeSet}. Duplicates will
 * not be added if the {@code compareTo} method has been correctly
 * implemented in each sub-class.
 * <p>
 * For each new solid, add it to a {@code HashSet}. Duplicates will
 * not be added if the {@code equals} method has been correctly
 * implemented in each sub-class.
 * <p>
 * Solids that are not valid will result in a {@code
 * InvalidSolidException}, which is caught be the code here.
 * <p>
 * When all solids have been read in, iterate through the {@code
 * TreeSet} to display all the different {@link Solid}s, in order of s
 * urface area.
 * <p>
 * Finally, display the largest and smallest solids (by surface area);
 * and then the total volume and surface of all the solids in the set.
 * @author Gilbert Laycock
 * @version $Id: CW2Phase3.java 316 2021-02-24 17:07:09Z gtl1 $
 */
class CW2Phase3 {
    /**
     * Main method that reads a file of solid specifications
     * @param args the name of the file of solid data should be supplied
     * as the one and only command line argument.
     */
    public static void main (final String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Controller <solidFile>");
            System.exit(1);
        }
        final String solFile = args[0];

        // read in the solids to an arrayList
        final SortedSet<Solid> solids1 = new TreeSet<>();
        final Set<Solid> solids2 = new HashSet<>();
        int solidCounter = 0;
        try (Scanner sc = new Scanner(new File(solFile))) {
            while (sc.hasNext()) {
                final String[] nextSolids = sc.nextLine().split("\\s");
                final Solid sol;
                try {
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
                            int c1=Integer.parseInt(nextSolids[0]);
                            int c2=Integer.parseInt(nextSolids[1]);
                            int c3=Integer.parseInt(nextSolids[2]);
                            sol = new Solid.Cuboid(c1,c2,c3);
                            break;
                        default:
                            System.out.printf("Unknown shape: %s%n",Arrays.toString(nextSolids));
                            sol=null;
                    };
                }
                catch (InvalidSolidException e) {
                    System.out.printf("Problem with creating solid %s :",
                            Arrays.toString(nextSolids));
                    System.out.println(e);
                    continue;
                }
                if (sol!=null) {
                    solidCounter++;
                    if (! solids1.add(sol))
                        System.out.printf("[SortedSet] Duplicate solid - not added: %s%n",
                                sol);
                    else
                        System.out.printf("[SortedSet] Added: %s%n",
                                sol);
                    if (! solids2.add(sol))
                        System.out.printf("[HashSet  ] Duplicate solid - not added: %s%n",
                                sol);
                    else
                        System.out.printf("[HashSet  ] Added: %s%n",
                                sol);
                }
            }
        }
        catch (IOException e) {
            System.err.printf("Error reading input file %s%n", solFile);
            e.printStackTrace();
            System.exit(1);
        }

        System.out.printf("Number of valid solids:    %3d%n",
                solidCounter);

        displaySolids(solids1, "SortedSet");
        displaySolids(solids2, "HashSet");

    }

    /**
     * Helper method to print out the contents of a Set&lt;Solid&gt; in a uniform way
     *
     * @param solids A Set of Solids
     * @param desc Text description of the set
     */
    static void displaySolids (final Set<Solid> solids, final String desc) {
        double totalSurface = 0.0;
        double totalVolume = 0.0;
        System.out.println();
        System.out.printf("%s Solids:%n",desc);
        for (Solid sh : solids) {
            System.out.printf("%s%nS=%6.2f V=%6.2f%n",
                    sh,
                    sh.getSurface(),
                    sh.getVolume());
            totalSurface += sh.getSurface();
            totalVolume += sh.getVolume();
        }

        // System.out.printf("%nLast solid is %s%n",
        //                   solids.last());
        // System.out.printf("First solid is %s%n",
        //                   solids.first());
        System.out.printf("Total surface area:        %6.2f%n",
                totalSurface);
        System.out.printf("Total volume:              %6.2f%n",
                totalVolume);
        System.out.printf("Count of different solids: %3d%n",
                solids.size());

    }
}