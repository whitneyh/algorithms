package me.whitneyhunter.heap;

public class Heap {

    public static void main(String[] args) {
        Heap.ofLength(10).run();
    }

    private void run() {
        for(int i = 0; i < 10; i++) {
            add((int)Math.floor(Math.random() * 100));
        }
        output();
        build_max_heap();
        output();
        heap_sort();
        output();
    }

    private int[] heap;
    private int size = 0;

    public static Heap ofLength(int length) {
        return new Heap(length);
    }

    public Heap(int length) {
        this.heap = new int[length];
    }

    public void add(int value) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size++] = value;
    }

    private void output() {
        System.out.println("Size: " + size);
        for(int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void heap_sort() {
        build_max_heap();
        for(int i = size - 1; i >= 1; i--) {
            swap(0, i);
            size--;
            max_heapify(0);
        }
    }

    public void build_max_heap() {
        for(int i = (size / 2) - 1; i >= 0; i--) {
            max_heapify(i);
        }
    }

    public void max_heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && heap[l] > heap[i]) {
            largest = l;
        }
        if (r < size && heap[r] > heap[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            max_heapify(largest);
        }
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
