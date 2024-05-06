package top.shanhai1024;

import java.util.*;

/**
 * @author null
 * java广度优先算法实现
 */
public class Bfs {
    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("A",new String[]{"D", "E", "B"});
        graph.put("B",new String[]{"C"});
        graph.put("C",new String[]{"F"});
        graph.put("D",new String[]{"G"});
        graph.put("E",new String[]{"I"});
        graph.put("F",new String[]{"E", "I"});
        graph.put("G",new String[]{"H"});
        graph.put("H",new String[]{"I"});
        graph.put("I",new String[]{});

        List<String> a = dfs(graph, "A");
        System.out.println(a);


    }

    public static List<String> dfs(Map<String, String[]> graph, String start) {
        LinkedList<String>queue = new LinkedList<>();
        ArrayList<String> visited= new ArrayList<>();
        List<String> visitOrder=new ArrayList<>();
        queue.add(start);
        visited.add(start);
        while (! queue.isEmpty()){
            String current = (queue.pop());
            visitOrder.add(current);
            String[] neighbours = graph.get(current); // 获取当前节点的邻居数组
            if (neighbours != null) { // 检查邻居数组是否为空
                Arrays.stream(neighbours)
                        .forEach(neighbour -> {
                            if (!visited.contains(neighbour)) {
                                queue.add(neighbour);
                                visited.add(neighbour);
                            }
                        });
            }
        }
        return visitOrder;

    }
}
