import java.util.*;
import java.util.stream.*;

public class FlajoletMartin {

    // ---- Tunable parameters ----
    static final int B = 10;                 // number of bits used for bucket index
    static final int M = 1 << B;             // number of registers = 2^B
    static final double ALPHA = 0.39701;     // LogLog correction constant
    static final long   SEED  = 0x9E3779B97F4A7C15L; // for hashing

    // ---------------------------------------------------------------
    // Hashing: convert an arbitrary String into a 32-bit uniform hash.
    // ---------------------------------------------------------------
    static int hash(String s) {
        long h = 1125899906842597L;           // large prime
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        // Final 64-bit avalanche mix (splitmix64-style) → reduces collisions
        h ^= (h >>> 33);
        h *= 0xff51afd7ed558ccdL;
        h ^= (h >>> 33);
        h *= 0xc4ceb9fe1a85ec53L;
        h ^= (h >>> 33);
        return (int) (h & 0xFFFFFFFFL);       // keep low 32 bits
    }

    // ---------------------------------------------------------------
    // Count position of the leftmost 1 bit in the lower (32 - B) bits.
    // Returns 1 if the very first bit (after bucket index) is 1,
    // returns (32 - B) + 1 if the entire remainder is zero.
    // ---------------------------------------------------------------
    static int rho(int hash32) {
        // Shift out the bucket index (top B bits)
        int remaining = hash32 << B;          // left-align the "rest"
        if (remaining == 0) return 32 - B;    // all remaining bits are zero
        return Integer.numberOfLeadingZeros(remaining) - B + 1;
    }

    // ---------------------------------------------------------------
    // Main FM processing: iterate over the stream and update registers.
    // ---------------------------------------------------------------
    static int[] buildRegisters(Iterable<String> stream) {
        int[] registers = new int[M];
        for (String item : stream) {
            int h = hash(item);
            int bucket = (h >>> (32 - B));    // top B bits → bucket index
            int r = rho(h);
            if (r > registers[bucket]) {
                registers[bucket] = r;
            }
        }
        return registers;
    }

    // ---------------------------------------------------------------
    // Estimate cardinality from registers using the LogLog formula.
    // ---------------------------------------------------------------
    static double estimate(int[] registers) {
        long sum = 0;
        for (int r : registers) sum += r;
        double mean = (double) sum / M;
        return ALPHA * M * Math.pow(2.0, mean);
    }

    // ---------------------------------------------------------------
    // Ground truth: exact distinct count using a HashSet.
    // ---------------------------------------------------------------
    static long exactDistinct(Iterable<String> stream) {
        Set<String> seen = new HashSet<>();
        for (String s : stream) seen.add(s);
        return seen.size();
    }

    // ---------------------------------------------------------------
    // Utility: build a synthetic stream with many distinct items and
    // some duplicates, mimicking real-world traffic.
    // ---------------------------------------------------------------
    static List<String> generateUsernames(int distinctCount, int totalSize) {
        List<String> stream = new ArrayList<>(totalSize);
        Random rnd = new Random(42);
        for (int i = 0; i < totalSize; i++) {
            int id = rnd.nextInt(distinctCount);   // duplicates via random draw
            stream.add("user_" + id);
        }
        return stream;
    }

    static List<String> generateIPs(int distinctCount, int totalSize) {
        List<String> stream = new ArrayList<>(totalSize);
        Random rnd = new Random(7);
        for (int i = 0; i < totalSize; i++) {
            int id = rnd.nextInt(distinctCount);
            stream.add("192.168." + (id / 256) + "." + (id % 256));
        }
        return stream;
    }

    static List<String> generateSearchTerms(int distinctCount, int totalSize) {
        List<String> stream = new ArrayList<>(totalSize);
        Random rnd = new Random(11);
        String[] words = {"java","docker","mongodb","hadoop","stream","algo",
                          "bloom","flajolet","mapreduce","sql"};
        for (int i = 0; i < totalSize; i++) {
            int id = rnd.nextInt(distinctCount);
            stream.add(words[id % words.length] + "_" + id);
        }
        return stream;
    }

    // ---------------------------------------------------------------
    // Driver
    // ---------------------------------------------------------------
    static void runScenario(String name, List<String> stream, long trueDistinct) {
        int[] registers = buildRegisters(stream);
        double estimate = estimate(registers);
        long exact = exactDistinct(stream);
        double relErr = Math.abs(estimate - exact) / (double) exact * 100.0;

        System.out.println("----------------------------------------------");
        System.out.println("Scenario       : " + name);
        System.out.println("Stream size    : " + stream.size());
        System.out.println("Exact distinct : " + exact);
        System.out.println("FM estimate    : " + String.format("%.2f", estimate));
        System.out.println("Relative error : " + String.format("%.3f%%", relErr));
        System.out.println("Memory used    : " + M * 4 + " bytes  (" + M + " int registers)");
    }

    public static void main(String[] args) {
        System.out.println("==== Flajolet–Martin Distinct Count Estimator ====");
        System.out.println("Registers M = " + M + "  |  Bucket bits b = " + B);

        runScenario("Distinct Usernames",
                    generateUsernames(50_000, 500_000), 50_000);

        runScenario("Distinct IP Addresses",
                    generateIPs(20_000, 500_000), 20_000);

        runScenario("Distinct Search Terms",
                    generateSearchTerms(10_000, 300_000), 10_000);
    }
}