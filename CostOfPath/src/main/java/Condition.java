import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Condition {

    int numberOfTests; // Number of tests in all conditions
    int testNumber;
    int numberOfCities; // Number of cities in one test
    int numberOfPaths; // Number of paths in one test
    List<City> cities = new ArrayList<>();
    // Pairs of cities between which I need to find the minimum cost
    Set<String> pairsOfCities = new HashSet<>();

    public Condition() {
    }
}
