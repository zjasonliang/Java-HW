package ds;
import sample.Main;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}
    private int getParentIndex(int chilIndex) {return (chilIndex - 1) / 2;}

    private boolean hasLeftChild(int index) {return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) {return getRightChildIndex(index) < size;}
    private boolean hasParent(int index) {return getParentIndex(index) >= 0;}

    private int getLeftChild(int index) {return items[getLeftChildIndex(index)];}
    private int getRightChild(int index) {return items[getRightChildIndex(index)];}
    private int getParent(int index) {return items[getParentIndex(index)];}

    private void swap(int index1, int index2) {
        int tmp = items[index1];
        items[index1] = items[index2];
        items[index2] = tmp;
    }

    private void ensureExtraCapacity(){
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
                capacity *= 2;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(String.valueOf(items[i]) + ' ');
        }
        System.out.println('\n');
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    private void heapifyDown() {
        int currentIndex = 0;
        // only need to check whether it has a left child.
        // if it doesn't, it certainly has no right child.
        while (hasLeftChild(currentIndex)) {
            int smallerChildIndex = getLeftChildIndex(currentIndex);
            if (hasRightChild(currentIndex) && getRightChild(currentIndex) < getLeftChild(currentIndex)) {
                smallerChildIndex = getRightChildIndex(currentIndex);
            }

            if (items[currentIndex] < items[smallerChildIndex]) {
                break;
            } else {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
            }
        }
    }

    private void heapifyUp() {
        int currentIndex = size - 1;
        while (hasParent(currentIndex) && getParent(currentIndex) > items[currentIndex]) {
            swap(getParentIndex(currentIndex), currentIndex);
            currentIndex = getParentIndex(currentIndex);
        }
    }

    // access the minimum element and then remove it
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int root = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return root;
    }

    // add a new element to the heap
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public static void main(String [] args){
        MinHeap h = new MinHeap();
        h.add(3);
        h.add(5);
        h.add(2);
        h.add(77);
        h.add(22);
        h.add(32);
        h.add(6);
        h.add(19);
        h.add(36);
        h.add(2);
        h.print();
    }
}
