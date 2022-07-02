import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {

        ReadInputFile readInputFile = new ReadInputFile();
        // Create collection conditions
        Map<Integer, Condition> conditions = new HashMap<>();
        readInputFile.read(conditions);
        int numberOfTests = conditions.size();
        // Iterate over all conditions
        for (int s = 1; s <= numberOfTests; s++) {
            Condition condition = new Condition();
            condition = conditions.get(s);
            // Creating an array for all costs
            Integer[][] arrayCosts =
                    new Integer[condition.numberOfCities + 1][condition.numberOfCities + 1];
            writeArrayCosts(condition, arrayCosts);
            Calculate calculate = new Calculate();
            System.out.println(calculate.calculate(condition, arrayCosts));
        }
    }

    private void writeArrayCosts(Condition condition, Integer[][] arrayCosts) {
        // Preparing the array to fill with data
        for (int i = 1; i <= condition.numberOfCities; i++) {
            for (int j = 1; j <= condition.numberOfCities; j++) {
                if (i == j) {
                    arrayCosts[i][j] = 0;
                } else {
                    arrayCosts[i][j] = 2_000_000;
                }
            }
        }
        for (City city : condition.cities) {
            Set<Integer> idNeighbors = new HashSet<>();
            // We take all neighbors for each city
            idNeighbors = city.neighbors.keySet();
            for (Integer j : idNeighbors) {
                // We write the distance from each city to all its neighbors in an array
                arrayCosts[city.id][j] = city.neighbors.get(j);
            }
        }
    }
}
