import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("After:");
        printArray(numbers);
    }

    private static void mergeSort(int[] inputArray) {
        // Define variables
        int arrayLength = inputArray.length;
        if (arrayLength < 2) {
            return;
        }

        int midPoint = arrayLength / 2;
        int[] leftHalf = new int[midPoint];
        int[] rightHalf = new int[arrayLength - midPoint];

        // set values for half arrays
        for (int i = 0; i < midPoint; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midPoint; i < arrayLength; i++) {
            rightHalf[i - midPoint] = inputArray[i];
        }

        // Call function again until its as small as possible
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSide = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSide) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;

        }
        while (j < rightSide) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    private static void printArray(int[] inputArray) {
        for (int j : inputArray) {
            System.out.println(j);
        }
    }
}
