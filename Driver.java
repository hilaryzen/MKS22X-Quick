import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] data = new int[Integer.parseInt(args[0])];
    for (int i = 0; i < data.length; i++) {
      data[i] = (int)(Math.random() * 100);
    }
    //System.out.println(Arrays.toString(data));

    if (args[1] == "select") {
      //int k = 0;
      int k = (int)(Math.random() * data.length);
      System.out.println("k = " + k);
      int selected = Quick.quickselect(data, k);

      Arrays.sort(data);
      //System.out.println("Sorted array: " + Arrays.toString(data));
      if (data[k] == selected) {
        System.out.println("Select passed: selected = " + selected + ", data[k] = " + data[k]);
      } else {
        System.out.println("Select failed: selected = " + selected + ", data[k] = " + data[k]);
      }
    } else if (args[1] == "sort") {
      int[] data2 = new int[data.length];
      for (int i = 0; i < data.length; i++) {
        data2[i] = data[i];
      }
      quicksort(data, 0, data.length - 1);
      Arrays.sort(data2);
      for (int i = 0; i < data.length; i++) {
        if (data[i] != data2[i]) {
          System.out.println("Sort failed: i = " + i + ", data[i] = " + data[i] + ", data2[i] = " + data2[i]);
        }
        if (i == data.length - 1) {
          System.out.println("Sort passed");
        }
      }
    }
  }
}
