import java.util.Arrays;
import java.util.Random;

public class SortWithArray extends Thread implements SortingFunctions{
    private int n = 0;

    //private int[] originalArr = new int[n]; // I cant use bc my array empty (n = 0)
    private int[] originalArr;
    private int[] arr;
    
    private int[] sortedArray;
    Random random = new Random();

    public int getNumbers() {
        return n;
    }
    public void setNumbers(int numbers) {
        this.n = numbers;
    }
    public int[] getOriginalArr() {
        return originalArr;
    }
    public int[] getSortedArray() {
        return sortedArray;
    }

    public SortWithArray(int amountOfElements) {
        setNumbers(amountOfElements);
        originalArr = new int[n];
        generate();

    }

    // FUNCTIONS:
    @Override
    public void generate(){
        for (int i = 0; i < n; i++) {
            originalArr[i] = random.nextInt(1_000_000)+1;
        }
        sortedArray = Arrays.copyOf(originalArr, originalArr.length);
    arr = Arrays.copyOf(originalArr,originalArr.length);
        Arrays.sort(sortedArray);
}
    @Override
    public long simpleSort() {
        long startTime = System.nanoTime();
        int[] helperArray = new int[n];
        int temp, kj = 0;
        for (int i = 0; i < n; i++) {
            temp = -1;
            for (int j = 0; j < n; j++) {
                if (temp < arr[j]) {
                    temp = arr[j];
                    kj = j; // saglaba poziciju
                }
            }
            arr[kj] = 0;
            helperArray[n - (i + 1)] = temp;
        }
        arr = Arrays.copyOf(helperArray,helperArray.length);
        long endTime = System.nanoTime();
        long time = endTime - startTime;

/*        System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    @Override
    public long bubbleSort() {
        int i, j, temp;
        boolean swapped;
        long startTime = System.nanoTime();
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    @Override
    public long selectionSort() {
        int n = arr.length;
        long startTime = System.nanoTime();
        for (int i = 0; i < n-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;

/*        System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    @Override
    public long mergeSort() {
        int l = 0;
        int r = n-1;
        int m = 0;

        long startTime = System.nanoTime();
        if (l < r) {
            m = l + (r - l) / 2;

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
/*        System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;

            mergeSort(left, m);
            mergeSort(m + 1, right);

            merge(left, m, right);
        }
    }

    private void merge(int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    @Override
    public long quickSort(){
        int low = 0;
        int high = n-1;
        long startTime = System.nanoTime();
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
      /*  System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }
    private void quickSort(int low, int high){

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    @Override
    public long shellSort() {
        long startTime = System.nanoTime();
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        /*System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    @Override
    public long javaSort() {
        long startTime = System.nanoTime();
        Arrays.sort(arr);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
       /* System.out.println("algoritms");
        System.out.println(Arrays.toString(arr)); //Parbaude*/
        arr = Arrays.copyOf(originalArr,originalArr.length);
        return time;
    }

    public void run(){
        System.out.println("thread is running...");
    }

}
