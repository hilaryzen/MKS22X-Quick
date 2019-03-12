public class Quick {
  /*Modify the array such that:
  *1. Only the indices from start to end inclusive are considered in range
  *2. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *4. all elements in range that are larger than the pivot element are placed after the pivot element.
  *@return the index of the final position of the pivot element.
  */
  public static int partition(int[] data, int start, int end) {
    //Picking the pivot
    int pivotIndex = (int)(Math.random() * (end - start)) + start;
    int pivot = data[pivotIndex];
    //System.out.println("Pivot: " + pivot);
    //Switching pivot to the beginning
    data[pivotIndex] = data[start];
    data[start] = pivot;
    pivotIndex = start;
    start += 1;

    while (start != end) {
      if (data[start] > pivot) {
        //If start is on wrong side, switch with end
        int n = data[start];
        data[start] = data[end];
        data[end] = n;
        //End moves down one
        end -= 1;
      } else {
        //If start is on right side, move start up one
        start += 1;
      }
      //System.out.println(Arrays.toString(data));
    }

    //Placing pivot in correct position
    if (data[start] > pivot) {
      data[pivotIndex] = data[start - 1];
      data[start - 1] = pivot;
      pivotIndex = start - 1;
    } else {
      data[pivotIndex] = data[start];
      data[start] = pivot;
      pivotIndex = start;
    }

    //System.out.println(Arrays.toString(data));
    //System.out.println(testPartition(data, pivotIndex));
    return pivotIndex;
  }

  //Return the kth smallest value of the array
  public static int quickselect(int[] data, int k) {
    int pivot = partition(data, 0, data.length - 1);
    while (k != pivot) {
      if (k < pivot) {
        pivot = partition(data, 0, pivot - 1);
      } else {
        pivot = partition(data, pivot, data.length - 1);
      }
    }
    return pivot;
  }
}
