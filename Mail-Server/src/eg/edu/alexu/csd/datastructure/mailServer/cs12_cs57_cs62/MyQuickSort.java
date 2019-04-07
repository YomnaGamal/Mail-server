package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import eg.edu.alexu.csd.datastructure.stack.cs12.Stack;

/**
 * Created by Maks on 5/13/2017.
 */
public class MyQuickSort {
    private static int partition(Integer[] arr, int lo, int hi){

        int pivot=arr[hi];
        int i=lo-1;
        for(int j=lo; j<hi; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i,j);
            }
        }

        swap(arr,i+1, hi);

        return  i+1;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    private static void sort(Integer[] arr, int lo, int hi){
        if(lo<hi) {
            int pivotal = partition(arr, lo, hi);
            sort(arr,lo, pivotal-1);
            sort(arr,pivotal+1, hi);
        }
    }

    private void sortIterative(Integer[] arr, int lo, int hi){
        Stack stack=new Stack();
        int top=-1;
        stack.push(lo);
        stack.push(hi);

        while(top>=0){
            hi=(int) stack.pop();
            lo=(int) stack.pop();
            if(lo<hi) {
                int pivotal = partition(arr, lo, hi);
                if (pivotal - 1 > 1) {
                    stack.push(lo);
                    stack.push( pivotal - 1);
                }

                if (pivotal + 1 < hi) {
                    stack.push(pivotal + 1);
                    stack.push( hi);
                }
            }

        }
    }
    public class InsertionSort {
        public  void iterativeSort(Integer[] arr){
            for(int i=1; i<arr.length; i++){
                for(int j=i; j>0 && arr[j]<arr[j-1]; j--){
                    swap(arr, j, j-1);

                }
            }
        }

        public  void iterativeSort(Integer[] arr, int lo, int hi){
            for(int i=lo; i<hi; i++){
                for(int j=i; j>0 && arr[j]<arr[j-1]; j--){
                    swap(arr, j, j-1);

                }
            }
        }

        private void swap(Integer[] arr, int j, int i) {
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
    }
    private  void sortHybrid(Integer[] arr, int lo, int hi){
        while(lo<hi){
            if(hi-lo<30){
                InsertionSort insort=new InsertionSort();
                insort.iterativeSort(arr, lo, hi);
                return;
            }
            else {
                int pivotal= partition(arr, lo, hi);
                if(pivotal-lo<hi-pivotal){
                    sortHybrid(arr, lo, pivotal-1);
                    lo=pivotal+1;
                }
                else {
                    sortHybrid(arr, pivotal+1, hi);
                    hi= pivotal-1;
                }
            }
        }
    }

    public  void sortHybrid(Integer[] arr){
        sortHybrid(arr, 0, arr.length-1);
    }

    public  void sortIterative(Integer[] arr){
        sortIterative(arr, 0, arr.length-1);
    }

    public static  void sort(Integer[] arr){
        sort(arr, 0, arr.length-1);
    }
    public static void main(String a[]){
        
        Integer[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}