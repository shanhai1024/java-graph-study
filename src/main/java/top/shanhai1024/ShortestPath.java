package top.shanhai1024;

import java.util.*;

/**
 * @author null
 *  广度优先查找最短路径
 *
 */
import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("A", new String[]{"D", "E", "B"});
        graph.put("B", new String[]{"C"});
        graph.put("C", new String[]{"F"});
        graph.put("D", new String[]{"G"});
        graph.put("E", new String[]{"I"});
        graph.put("F", new String[]{"E", "I"});
        graph.put("G", new String[]{"H"});
        graph.put("H", new String[]{"I"});
        graph.put("I", new String[]{"J"});
        graph.put("J", new String[]{});

        List<String> shortestPath = bfsShortestPath(graph, "A", "J");
        System.out.println("Shortest path: " + shortestPath);
    }

    public static List<String> bfsShortestPath(Map<String, String[]> graph, String start, String end) {
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Integer> distances = new HashMap<>(); // 记录节点到起始节点的距离
        HashMap<String, String> previous = new HashMap<>(); // 记录节点的前驱节点
        List<String> shortestPath = new ArrayList<>();

        queue.add(start);
        distances.put(start, 0); // 起始节点到自身的距离为0

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                // 找到终点，构建最短路径并返回
                String node = end;
                while (node != null) {
                    shortestPath.add(0, node);
                    node = previous.get(node);
                }
                return shortestPath;
            }

            String[] neighbours = graph.get(current);
            if (neighbours != null) {
                for (String neighbour : neighbours) {
                    if (!distances.containsKey(neighbour)) {
                        queue.add(neighbour);
                        distances.put(neighbour, distances.get(current) + 1);
                        previous.put(neighbour, current);
                    }
                }
            }
        }
        return shortestPath; // 没有找到最短路径
    }
}
