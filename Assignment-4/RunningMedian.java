import java.util.PriorityQueue;

public class RunningMedian {
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half of numbers
    private PriorityQueue<Integer> minHeap; // Stores the larger half of numbers
    
    public RunningMedian() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNumber(int num) {
        // Ensure maxHeap and minHeap are balanced
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        
        // Balance heaps if necessary
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

}
