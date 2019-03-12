import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] data = new int[Integer.parseInt(args[0])];
    for (int i = 0; i < data.length; i++) {
      data[i] = (int)(Math.random() * 100);
    }
    //System.out.println(Arrays.toString(data));

    //int k = 0;
    int k = (int)(Math.random() * data.length);
    System.out.println("k = " + k);
    int selected = Quick.quickselect(data, k);

    Arrays.sort(data);
    //System.out.println("Sorted array: " + Arrays.toString(data));
    if (data[k] == selected) {
      System.out.println("Passed: selected = " + selected + ", data[k] = " + data[k]);
    } else {
      System.out.println("Failed: selected = " + selected + ", data[k] = " + data[k]);
    }
  }
}
