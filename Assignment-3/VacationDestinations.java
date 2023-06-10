import java.util.*;

 private static class City {
        String name;
        int travelTime;

        City(String name, int travelTime) {
            this.name = name;
            this.travelTime = travelTime;
        }
    }

public class Solution {
    public int countDestinations(String origin, int maxTravelTime, String[][] destinations) {
        
        Map<String, List<City>> adjList = new HashMap<>();
        for (String[] destination : destinations) {
            String city1 = destination[0];
            String city2 = destination[1];
            int travelTime = Integer.parseInt(destination[2]);
            adjList.putIfAbsent(city1, new ArrayList<>());
            adjList.putIfAbsent(city2, new ArrayList<>());
            adjList.get(city1).add(new City(city2, travelTime));
            adjList.get(city2).add(new City(city1, travelTime));
        }

       
        int count = 0;
        Set<String> visited = new HashSet<>();
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(origin, 0));

        while (!queue.isEmpty()) {
            City currentCity = queue.poll();
            String cityName = currentCity.name;
            int travelTime = currentCity.travelTime;

            if (travelTime <= maxTravelTime && !visited.contains(cityName)) {
                count++;
                visited.add(cityName);

               
                for (City neighbor : adjList.get(cityName)) {
                    queue.offer(new City(neighbor.name, travelTime + neighbor.travelTime + 1));
                }
            }
        }

        return count;
    }

}

// took 40 minutes
