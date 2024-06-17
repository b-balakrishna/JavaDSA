
import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<Integer>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int currentIndex = this.heap.size() - 1;
        while (currentIndex > 0 && this.heap.get(currentIndex) > this.heap.get(this.parent(currentIndex))) {
            this.swap(currentIndex, this.parent(currentIndex));
            currentIndex = this.parent(currentIndex);
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = this.leftChild(index);
            int rightIndex = this.rightChild(index);

            if (leftIndex < this.heap.size() && this.heap.get(leftIndex) > this.heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }
            if (rightIndex < this.heap.size() && this.heap.get(rightIndex) > this.heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            if (index != maxIndex) {
                this.swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (this.heap.size() == 0) {
            return null;
        }
        if (this.heap.size() == 1) {
            return this.heap.remove(0);
        }

        int maxValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        this.sinkDown(0);
        return maxValue;
    }

}
