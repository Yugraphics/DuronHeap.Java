public class LastnameHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public LastnameHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity + 1];
        this.size = 0;
    }

    // Get the index of the parent node
    private int getParent(int index) {
        return index / 2;
    }

    // Get the index of the left child node
    private int getLeftChild(int index) {
        return 2 * index;
    }

    // Get the index of the right child node
    private int getRightChild(int index) {
        return 2 * index + 1;
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Heapify up
    private void heapifyUp(int index) {
        if (index > 1) {
            int parentIndex = getParent(index);
            if (heap[index] > heap[parentIndex]) {
                swap(index, parentIndex);
                heapifyUp(parentIndex);
            }
        }
    }

    // Heapify down
    private void heapifyDown(int index) {
        int largest = index;
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);

        if (leftChildIndex <= size && heap[leftChildIndex] > heap[largest]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex <= size && heap[rightChildIndex] > heap[largest]) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Insert an element into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[++size] = value;
        heapifyUp(size);
    }

    // Remove the maximum element from the heap
    public int removeMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);
        return max;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LastnameHeap heap = new LastnameHeap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        System.out.println("Heap:");
        heap.printHeap();

        System.out.println("Maximum element: " + heap.removeMax());

        System.out.println("Heap after removal:");
        heap.printHeap();
    }
}