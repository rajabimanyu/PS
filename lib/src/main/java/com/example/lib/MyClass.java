package com.example.lib;

import java.util.ArrayList;

public class MyClass {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};


        MyPrograms myPrograms = new MyPrograms();

        int k = 3;

        ArrayList arrayList = new ArrayList<Integer>();
        for(int i = 0;i < k + 1;i++) {
            myPrograms.insertMin(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = myPrograms.getMin();
            myPrograms.decreaseKey();
            myPrograms.insertMin(arr[i]);
        }

        while (index != arr.length) {
            arr[index++] = myPrograms.getMin();
            myPrograms.decreaseKey();
        }

        for(int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
    }

    static class MyPrograms {
        int size = 0;
        int[] heap = new int[100];


        void decreaseKey() {
            if(heap.length > 0) {
                swap(0, size - 1);
                size--;
                minHeapify(0);
            }
        }

        private void minHeapify(int pos) {
            if(!isLeaf(pos)) {
                if(leftChild(pos) < size || rightChild(pos) < size) {
                    if(rightChild(pos) < size) {
                        if(heap[rightChild(pos)] < heap[leftChild(pos)]) {
                            if(heap[rightChild(pos)] < heap[pos]) {
                                swap(rightChild(pos), pos);
                                minHeapify(rightChild(pos));
                            }
                        } else {
                            if(heap[leftChild(pos)] < heap[pos]) {
                                swap(leftChild(pos), pos);
                                minHeapify(leftChild(pos));
                            }
                        }
                    } else {
                        if(heap[leftChild(pos)] < heap[pos]) {
                            swap(leftChild(pos), pos);
                            minHeapify(leftChild(pos));
                        }
                    }
                }
            }
        }

        private void maxHeapify(int pos) {
            if(!isLeaf(pos)) {
                if(leftChild(pos) < size || rightChild(pos) < size) {
                    if(rightChild(pos) < size) {
                        if(heap[rightChild(pos)] > heap[leftChild(pos)]) {
                            if(heap[rightChild(pos)] > heap[pos]) {
                                swap(rightChild(pos), pos);
                                maxHeapify(rightChild(pos));
                            }
                        } else {
                            if(heap[leftChild(pos)] > heap[pos]) {
                                swap(leftChild(pos), pos);
                                maxHeapify(leftChild(pos));
                            }
                        }
                    } else {
                        if(heap[leftChild(pos)] > heap[pos]) {
                            swap(leftChild(pos), pos);
                            maxHeapify(leftChild(pos));
                        }
                    }
                }
            }
        }

        private boolean isLeaf(int pos) {
            return pos <= size && pos > size / 2;
        }

        private int leftChild(int pos) {
            return (2 * pos) + 1;
        }

        private int rightChild(int pos) {
            return (2 * pos) + 2;
        }

        int getMin() {
            return heap[0];
        }

        void insertMax(int key) {
            heap[size] = key;
            int current = size;
            size++;
            while (heap[current] > heap[parentIndex(current)]) {
                swap(current, parentIndex(current));
                current = parentIndex(current);
            }
        }

        void insertMin(int key) {
            heap[size] = key;
            int current = size;
            size++;
            while (heap[current] < heap[parentIndex(current)]) {
                swap(current, parentIndex(current));
                current = parentIndex(current);
            }
        }

        private int parentIndex(int key) {
            return (key -1) / 2;
        }

        void swap(int sIndex, int eIndex) {
            int t = heap[sIndex];
            heap[sIndex] = heap[eIndex];
            heap[eIndex] = t;
        }

        void print() {
            for(int i = 0;i < size / 2;i++) {

                // Printing the parent and both childrens
                System.out.print(
                        " PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2]
                );

                // By here new line is required
                System.out.println();
            }
        }
    }
}