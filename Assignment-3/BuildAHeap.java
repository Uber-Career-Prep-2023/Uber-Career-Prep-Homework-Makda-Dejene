import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> arr; // the underlying array

    public Heap() {
        arr = new ArrayList<>();
    }

    public int top() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return arr.get(0);
    }

    public void insert(int x) {
        arr.add(x);
        heapifyUp(arr.size() - 1);
    }

    public void remove() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && arr.get(index) < arr.get((index-1)/2)) {
            swap(index,  (index-1)/2);
            index = (index-1)/2;
        }
    }

    private void heapifyDown(int index) {
        int i = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < arr.size() && arr.get(left) < arr.get(i)) {
            i = left;
        }
       if (right < arr.size() && arr.get(right) < arr.get(i)) {
            i = right;
        }

        if (i != index) {
            swap(index, i);
            heapifyDown(i);
        }
    }


    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
// took 40 minutes
