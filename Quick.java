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

    //lo and hi move toward each other to find pivot
    int lo = start;
    int hi = end;

    while (lo != hi) {
      //Second and statement creates 50% chance that a duplicate will be switched
      if (data[lo] > pivot || (data[lo] == pivot && (int)(Math.random() * 2) % 2 == 0)) {
        //If start is on wrong side, switch with end
        int n = data[lo];
        data[lo] = data[hi];
        data[hi] = n;
        //End moves down one
        hi -= 1;
      } else {
        //If start is on right side, move start up one
        lo += 1;
      }
      //System.out.println(Arrays.toString(data));
    }

    //Placing pivot in correct position
    if (data[lo] > pivot) {
      data[pivotIndex] = data[lo - 1];
      data[lo - 1] = pivot;
      pivotIndex = lo - 1;
    } else {
      data[pivotIndex] = data[lo];
      data[lo] = pivot;
      pivotIndex = lo;
    }

    //System.out.println(Arrays.toString(data));
    //System.out.println(testPartition(data, pivotIndex));
    return pivotIndex;
  }

  //Return the kth smallest value of the array
  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    int pivot = partition(data, start, end);
    while (k != pivot) {
      if (k < pivot) {
        end = pivot - 1;
        //pivot = partition(data, 0, pivot - 1);
      } else {
        start = pivot;
        //pivot = partition(data, pivot, data.length - 1);
      }
      pivot = partition(data, start, end);
    }
    return data[pivot];
  }
}
