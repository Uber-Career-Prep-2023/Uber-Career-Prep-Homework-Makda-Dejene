import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<Pair<String, Integer>> arr; 

    public PriorityQueue() {
        arr = new ArrayList<>();
    }

    public String top() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return arr.get(0).getKey();
    }

    public void insert(String x, int weight) {
        arr.add(new Pair<>(x, weight));
        heapifyUp(arr.size() - 1);
    }

    public void remove() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && arr.get(index).getValue() > arr.get((index - 1) / 2)).getValue()) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < arr.size() && arr.get(left).getValue() > arr.get(largest).getValue()) {
            largest = left;
        }

        if (right < arr.size() && arr.get(right).getValue() > arr.get(largest).getValue()) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        Pair<String, Integer> temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
  
  // took 20 minutes
