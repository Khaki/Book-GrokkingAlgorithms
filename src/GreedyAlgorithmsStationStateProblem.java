import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class GreedyAlgorithmsStationStateProblem {

    // Setup
    private static Set<String> states_needed = new HashSet<>(){
        {
            add("mt");
            add("wa");
            add("or");
            add("id");
            add("nv");
            add("ut");
            add("ca");
            add("az");
        }
    };

    private static Map<String, Set<String>> stations = new HashMap<>(){
        {
            put("k1",Set.of("id","nv","ut"));
            put("k2",Set.of("wa","id","mt"));
            put("k3",Set.of("or","nv","ca"));
            put("k4",Set.of("nv","ut"));
            put("k5",Set.of("ca","az"));
        }
    };

    private static Set<String> final_stations = new HashSet<>();



    public static void main(String[] args)
    {
        while(states_needed.size() > 0) {
            Set<String> states_covered = new HashSet<>();
            String station_most_covered = "";
            Set<String> states_most_covered = new HashSet<>();

            for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                states_covered = new HashSet<>(states_needed);
                states_covered.retainAll(station.getValue());
                if(states_covered.size() > states_most_covered.size())
                {
                    states_most_covered = new HashSet<>(states_covered);
                    station_most_covered = station.getKey();
                }
            }
            final_stations.add(station_most_covered);

            stations.remove(station_most_covered);
            states_needed.removeAll(states_most_covered);
        }

        System.out.println(final_stations.stream().sorted().collect(toSet()));
    }

}
