package com.example.lib

import java.util.*

fun main(args: Array<String>) {
    val myPrograms = MyPrograms()


    val matrix = arrayOf(3,2,1,5,6,4)
        for(element in matrix) {
            myPrograms.insert(element)
        }

    myPrograms.print()

    val k = 2
    for(i in 1 until k){
        myPrograms.decreaseKey()
    }
    myPrograms.print()
    println("ff : ${myPrograms.getMin()}")
}

class MyPrograms {
    var size: Int = 0
    val heap = IntArray(100)

    fun decreaseKey() {
        if(heap.isNotEmpty()) {
            swap(0, size - 1)
            size--
            maxHeapify(0)
        }
    }

    private fun minHeapify(pos: Int) {
        if(!isLeaf(pos)) {
            if(leftChild(pos) < size || rightChild(pos) < size) {
                if(rightChild(pos) < size) {
                    if(heap[rightChild(pos)] < heap[leftChild(pos)]) {
                        if(heap[rightChild(pos)] < heap[pos]) {
                            swap(rightChild(pos), pos)
                            minHeapify(rightChild(pos))
                        }
                    } else {
                        if(heap[leftChild(pos)] < heap[pos]) {
                            swap(leftChild(pos), pos)
                            minHeapify(leftChild(pos))
                        }
                    }
                } else {
                    if(heap[leftChild(pos)] < heap[pos]) {
                        swap(leftChild(pos), pos)
                        minHeapify(leftChild(pos))
                    }
                }
            }
        }
    }

    private fun maxHeapify(pos: Int) {
        if(!isLeaf(pos)) {
            if(leftChild(pos) < size || rightChild(pos) < size) {
                if(rightChild(pos) < size) {
                    if(heap[rightChild(pos)] > heap[leftChild(pos)]) {
                        if(heap[rightChild(pos)] > heap[pos]) {
                            swap(rightChild(pos), pos)
                            maxHeapify(rightChild(pos))
                        }
                    } else {
                        if(heap[leftChild(pos)] > heap[pos]) {
                            swap(leftChild(pos), pos)
                            maxHeapify(leftChild(pos))
                        }
                    }
                } else {
                    if(heap[leftChild(pos)] > heap[pos]) {
                        swap(leftChild(pos), pos)
                        maxHeapify(leftChild(pos))
                    }
                }
            }
        }
    }

    private fun isLeaf(pos: Int) : Boolean {
        return pos <= size && pos > size / 2
    }

    private fun leftChild(pos: Int): Int {
        return (2 * pos) + 1
    }

    private fun rightChild(pos: Int) : Int {
        return (2 * pos) + 2
    }

    fun getMin(): Int {
        return heap[0]
    }

    fun insert(key: Int) {
        heap[size] = key
        var current = size
        size++
        while (heap[current] > heap[parentIndex(current)]) {
            swap(current, parentIndex(current))
            current = parentIndex(current)
        }
    }

    private fun parentIndex(key: Int) : Int {
        return (key -1) / 2
    }

    fun swap(sIndex: Int, eIndex: Int) {
        val t = heap[sIndex]
        heap[sIndex] = heap[eIndex]
        heap[eIndex] = t
    }

    fun print() {
        for (i in 0 until (size / 2)) {

            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + heap.get(i)
                    .toString() + " LEFT CHILD : " + heap.get(2 * i + 1)
                    .toString() + " RIGHT CHILD :" + heap.get(2 * i + 2)
            )

            // By here new line is required
            println()
        }
    }
}