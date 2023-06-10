import java.util.*;

class Element {
    public int row, col, val;

    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    private Comparator<Element> elementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    public int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        int totalSize = 0;
        Queue<Element> minHeap = new PriorityQueue<>(arrays.length, elementComparator);

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                minHeap.add(element);
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;
        while (!minHeap.isEmpty()) {
            Element element = minHeap.poll();
            result[index++] = element.val;
            if (element.col + 1 < arrays[element.row].length) {
                element.col += 1;
                element.val = arrays[element.row][element.col];
                minHeap.add(element);
            }
        }

        return result;
    }
  
  // took 35 minutes
