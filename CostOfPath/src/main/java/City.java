import java.util.HashMap;

public class City {

    int id;
    String name;
    int numberOfNeighbors;
    HashMap<Integer, Integer> neighbors = new HashMap<Integer, Integer>();

    public City() {
    }
}
