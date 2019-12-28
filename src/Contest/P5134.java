package Contest;

public class P5134 {
    public int[] replaceElements(int[] arr) {
        int greatest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = greatest;
            greatest = Math.max(greatest, temp);
        }
        return arr;
    }
}
