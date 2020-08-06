import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {2,4,5,3,7};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    //插入排序 时间复杂度：O(N^2) 空间复杂度：O(1) 稳定性：稳定排序
    public static void insertSort(int[] array){
        for(int bound = 1; bound <array.length; bound++){
            int v = array[bound];
            int cur = bound -1;
            for(; cur >= 0; cur--){
                if(array[cur] > v){
                    array[cur+1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+1] = v;
        }
    }

    //希尔排序 时间复杂度;理论上能到O（N^1.3) 此时是O(N^2) 空间复杂度：O(1) 稳定性：不稳定
    public static void shellSort(int[] array){
        int gap = array.length/2;
        while(gap > 1){
            insertSortGap(array,gap);
            gap /= 2;
        }
        insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for(int bound = 1; bound <array.length; bound++){
            int v = array[bound];
            int cur = bound -gap;
            for(; cur >= 0; cur -= gap){
                if(array[cur] > v){
                    array[cur+gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+gap] = v;
        }
    }

    //选择排序 时间复杂度：O(N^2) 空间复杂度：O(1) 稳定性：不稳定
    public static void selectSort(int[] array){
        for(int bound = 0; bound < array.length ; bound++){
            for(int cur = bound+1; cur < array.length; cur++){
                if(array[cur] < array[bound]){
                    int ret = array[cur];
                    array[cur] = array[bound];
                    array[bound] = ret;
                }
            }
        }
    }

    private  static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //堆排序 时间复杂度：O（N*logN）空间复杂度：O(1) 稳定性：不稳定
    public static void heapSort(int[] array){
        //建堆
        createHeap(array);
        //循环把堆顶元素交换到最后，并进行堆调整
        for (int i = 0; i < array.length-1; i++) {
            swap(array,0,array.length-1-i);
            shiftDown(array,array.length-1-i,0);
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length-1-1) / 2; i >= 0 ; i--) {
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child < heapLength){
            if(child +1 < heapLength && array[child + 1] > array[child]){
                child = child+1;
            }
            if(array[child] > array[parent]){
                swap(array, child , parent);
            }else{
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //冒泡排序 时间复杂度：O(N^2) 空间复杂度：O(1) 稳定性：稳定排序

    public  static void bubbleSort(int[] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j <array.length -1 -i ; j++) {
                if(array[j] > array[j +1]){
                    swap(array,j,j +1);
                }
            }
        }
    }

    //快速排序 平均时间复杂度：O(NlogN) 空间复杂度：O()
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array,int left, int right) {
        if(left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index -1);
        quickSortHelper(array, index +1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int ret = array[right];
        while(i <j){
            while(i <j && array[i] <= ret){
                i++;
            }
            while (i <j && array[j] >= ret){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }
    //归并排序
    public  static void merge(int[] array, int low, int mid, int high){
        int[] output = new int[high - low];
        int outputIndex = 0;
        int cur1 = low;
        int cur2 = mid;
        while(cur1 < mid && cur2 < high){
            if(array[cur1] <= array[cur2]){
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }else{
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        while (cur1 < mid){
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while (cur2 < mid){
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }
}
