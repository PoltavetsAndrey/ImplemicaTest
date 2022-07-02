import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ReadInputFile {

    public void read(Map<Integer, Condition> conditions) {
        int numberOfTests = 0;
        // Read data from file "input.txt"
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("input.txt"), StandardCharsets.UTF_8))) {
            String line;
            String bufer = "";
            int testNumber = 1;
            do {
                numberOfTests = Integer.parseInt(reader.readLine());
                // Create an object condition
                Condition condition = new Condition();
                // Write data from file to condition
                condition.numberOfTests = numberOfTests;
                condition.testNumber = testNumber;
                condition.numberOfCities = Integer.parseInt(reader.readLine());
                // Path through all cities
                for (int i = 1; i <= condition.numberOfCities; i++) {
                    City city = new City();
                    city.id = i;
                    city.name = reader.readLine();
                    city.numberOfNeighbors = Integer.parseInt(reader.readLine());
                    // Path through all neighbors
                    for (int j = 0; j < city.numberOfNeighbors; j++) {
                        line = reader.readLine().trim();
                        int idNeighbors;
                        int costToNeighbors;
                        int z = 0;
                        // Read idNeighbors
                        while (line.charAt(z) != ' ') {
                            bufer = bufer.concat(String.valueOf(line.charAt(z)));
                            z++;
                        }
                        idNeighbors = Integer.parseInt(bufer);
                        bufer = "";
                        z++;
                        // Read cost from this city to this Neighbors
                        while (z < line.length()) {
                            bufer = bufer.concat(String.valueOf(line.charAt(z)));
                            z++;
                        }
                        costToNeighbors = Integer.parseInt(bufer);
                        bufer = "";
                        // Recording all neighbors for each city
                        city.neighbors.put(idNeighbors,
                                costToNeighbors);
                    }
                    // Recording all cities for each condition
                    condition.cities.add(city);
                }
                condition.numberOfPaths = Integer.parseInt(reader.readLine());
                for (int i = 0; i < condition.numberOfPaths; i++) {
                    condition.pairsOfCities.add(reader.readLine());
                }
                // Check for invalid input of an empty string
                reader.readLine();
                conditions.put(condition.testNumber, condition);
                testNumber++;
            } while (testNumber <= numberOfTests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
