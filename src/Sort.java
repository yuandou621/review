import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {2,4,5,3,7};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        heapSort(array);
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
            insretSortGap(array,gap);
            gap /= 2;
        }
        insretSortGap(array,1);
    }
    private static void insretSortGap(int[] array, int gap) {
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

    //堆排序
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

}
