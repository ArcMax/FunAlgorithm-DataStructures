public class BinaryHeapImplementation {
    private int[] data;
    private int heapSize;

    public BinaryHeapImplementation(int size){
        data = new int[size];
        heapSize = 0;
    }

    public int getMinimum(){
        if(isEmpty()){
            throw new HeapException("Heap is Empty");
        }
        return data[0];
    }

    public boolean isEmpty(){
        return heapSize ==0;
    }

    private int getChildLeftIndex(int nodeIndex){
        return 2*nodeIndex+1;
    }

    private int getChildRightIndex(int nodeIndex){
        return 2*nodeIndex+2;
    }

    private int getParentIndex(int nodeIndex){
        return (nodeIndex-1)/2;
    }

    public class HeapException extends RuntimeException {

        public HeapException(String message) {

            super(message);

        }

    }

    public void insert(int value){
        if(heapSize == data.length){
            throw new HeapException("heap overflow");
        }
        heapSize++;
        data[heapSize-1] = value;
        heapifyUp(heapSize-1);
    }

    private void heapifyUp(int nodeIndex) {
        int parentIndex,temp;
        if(nodeIndex != 0){
            parentIndex = getParentIndex(nodeIndex);
            if(data[parentIndex] > data[nodeIndex]){
                temp = data[parentIndex];
                data[parentIndex] = data[nodeIndex];
                data[nodeIndex] = temp;
                heapifyUp(parentIndex);
            }
        }
    }
//    http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
}
