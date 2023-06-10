import java.util.*;

public class PrerequisiteCourses {
    public String[] findOrder(int numCourses, String[][] prerequisites) {
        
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] i : prerequisites) {
            String course = i[0];
            String prerequisiteCourse = i[1];
            adjList.putIfAbsent(prerequisiteCourse, new ArrayList<>());
            adjList.get(prerequisiteCourse).add(course);
        }

       
        Map<String, Boolean> map = new HashMap<>();
        Map<String, Boolean> recursionStack = new HashMap<>();

        
        Stack<String> stack = new Stack<>();
        for (String course : adjList.keySet()) {
            if (!map.containsKey(course) && hasCycle(course, adjList, map, recursionStack, stack)) {
                return new String[0];
            }
        }

       
        String[] order = new String[numCourses];
        int index = numCourses - 1;
        while (!stack.isEmpty()) {
            order[index--] = stack.pop();
        }

        return order;
    }

    private boolean hasCycle(String course, Map<String, List<String>> adjList, Map<String, Boolean> map,
                             Map<String, Boolean> recursionStack, Stack<String> stack) {
        map.put(course, true);
        recursionStack.put(course, true);

        if (adjList.containsKey(course)) {
            for (String prerequisite : adjList.get(course)) {
                if (!map.containsKey(prerequisite)) {
                    if (hasCycle(prerequisite, adjList, map, recursionStack, stack)) {
                        return true;
                    }
                } else if (recursionStack.containsKey(prerequisite)) {
                    return true;
                }
            }
        }

        recursionStack.remove(course);
        stack.push(course);
        return false;
    }

    
}
// took 40 minutes
