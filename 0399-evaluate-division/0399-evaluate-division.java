import java.util.*;

public class Solution {
    // 그래프를 인접 리스트로 표현
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프를 구성
        buildGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            result[i] = dfs(numerator, denominator, new HashSet<>());
        }
        return result;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());

            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1.0 / value);
        }
    }

    private double dfs(String current, String target, Set<String> visited) {
        if (!graph.containsKey(current) || !graph.containsKey(target)) {
            return -1.0;
        }
        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(neighbor, target, visited);
                if (result != -1.0) {
                    return result * neighbors.get(neighbor);
                }
            }
        }

        return -1.0;
    }
}
