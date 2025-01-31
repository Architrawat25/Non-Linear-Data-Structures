public class Heap {
    /*
        left -> 2i+1
        right -> 2i+2
        parent -> i-1/2
    */


    int[] heap;
    int size;
    int maxSize;

    Heap(int maxSize){
        this.maxSize=maxSize;
        this.heap=new int[maxSize];
        this.size=0;
    }

    public int left(int pos){
        return (2*pos)+1;
    }
    public int right(int pos){
        return (2*pos)+2;
    }
    public int parent(int pos){
        return (pos-1)/2;
    }

    public void swap(int pos1, int pos2){
        int temp=heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;
    }
    public void insert(int data){
        int pos=size;
        heap[pos]=data;
//        if heap property is violated or not
//        MAX HEAP
        while(heap[pos]>heap[parent(pos)]){
            swap(pos, parent(pos));
            pos=parent(pos);
        }
        size++;
    }

    public void display(){
        for(int i=0;i<size/2;i++){
            System.out.print("parent"+heap[i]+" | ");
            System.out.print("left"+heap[left(i)]+" | ");
            System.out.print("right"+heap[right(i)]+" | ");
            System.out.println();
        }
    }

    public int extractMax(){
        int del=heap[0];
        heap[0]=heap[--size];

        heapify(0);
        return del;
    }
    public void heapify(int index){
        if(heap[index]<heap[left(index)] || heap[index]<heap[right(index)]){
            if(heap[index]<heap[left(index)]){
                swap(index, right(index));
                heapify(right(index));
            }
            else{
                swap(index, left(index));
                heapify(left(index));
            }
        }
    }


}
