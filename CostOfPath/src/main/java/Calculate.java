import static java.lang.Math.min;

public class Calculate {

    int idStart = 0; // Source
    int idFinish = 0; // Destination
    String output = "";

    public String calculate(Condition condition, Integer[][] arrayCosts) {

        // Iterate over pairs of cities for which I need to find the minimum cost
        for (String stringSet : condition.pairsOfCities) {
            findStartFinish(condition, stringSet);
            output = output.concat(findMinCosts(condition, arrayCosts) + "\n");
        }
        return output;
    }

    private int findMinCosts(Condition condition, Integer[][] arrayCosts) {
        int maxDist = 2_000_000; // Maximum cost
        int cityNum = condition.numberOfCities; // Number of cities
        int[] cost = new int[cityNum + 1]; // Array of costs from start to all cities
        // Array of notes about the use of the city
        boolean[] used = new boolean [cityNum + 1];
        // Set the maximum cost to all cities
            for (int i = 1; i <= cityNum; i++) {
                cost[i] = maxDist;
            }
        cost[idStart] = 0; // For the starting city
        for (;;) {
                int idToCity = -1;
                // Each of cities
                for (int nextCity = 1; nextCity <= cityNum; nextCity++) {
                    // choose the closest unmarked city
                    if (!used[nextCity] && cost[nextCity] < maxDist &&
                            (idToCity == -1 || cost[idToCity] > cost[nextCity])) {
                        idToCity = nextCity;
                    }
                }
                if (idToCity == -1) {
                    break; // nearest city not found
                }
                used[idToCity] = true; // mark it
                for (int nextCity = 1; nextCity <= cityNum; nextCity++)
                    // for all unlabeled neighbors
                    if (!used[nextCity] && arrayCosts[idToCity][nextCity] < maxDist)
                        // improve cost estimation
                        cost[nextCity] = min(cost[nextCity],
                                cost[idToCity] + arrayCosts[idToCity][nextCity]);
        }
        return cost[idFinish]; // Returning the minimum cost to the target
    }

    public void findStartFinish(Condition condition, String stringSet) {
        String nameStart = "";
        String nameFinish = "";
        int i;
        System.out.println(stringSet);
        i = 0;
        while (stringSet.charAt(i) != ' ') { // We separate the start
            nameStart = nameStart + stringSet.charAt(i);
            i++;
        }
        i++;
        while (i < stringSet.length()) { // We separate the finish
            nameFinish = nameFinish + stringSet.charAt(i);
            i++;
        }
        for (City city : condition.cities) {
            if (nameStart.equals(city.name)) {
                idStart = city.id;
            }
            if (nameFinish.equals(city.name)) {
                idFinish = city.id;
            }
        }
    }
}
