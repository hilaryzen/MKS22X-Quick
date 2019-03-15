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
    //int pivotIndex = (int)(Math.random() * (end - start)) + start;
    int pivotIndex = median(data, start, (start + end) / 2, end);
    int pivot = data[pivotIndex];
    //System.out.println("Pivot: " + pivot);
    //Switching pivot to the beginning
    if (pivotIndex != start) {
      data[pivotIndex] = data[start];
      data[start] = pivot;
      pivotIndex = start;
    }

    //lo and hi move toward each other to find pivot
    int lo = start + 1;
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

  //Creates a third section for values equal to the pivot to save time
  private int[] partitionDutch(int[] data, int start, int end) {
    //Array will be separated into 3 sections with lt, i, gt
    //lt tracks the pivot, i is the element being considered
    //Values from start to lt are less than pivot, from lt to i are equal to pivot
    //Values from i to gt are unknown, from gt to end are higher

    //Picking the pivot
    int lt = median(data, start, (start + end) / 2, end);
    int pivot = data[lt];

    //Switching pivot to the beginning
    if (pivotIndex != start) {
      data[pivotIndex] = data[start];
      data[start] = pivot;
      pivotIndex = start;
    }

    int i = lt + 1;
    int gt = end;

    while (i != gt) {
      if (data[i] < pivot) {
        //Switches i with lt and increases both by 1
        data[lt] = data[i];
        data[i] = pivot;
        lt += 1;
        i += 1;
      } else if (data[i] == pivot) {
        //Continues onto next element
        i += 1;
      } else {
        //Switches i and gt
        int value = data[i];
        data[i] = data[gt];
        data[gt] = value;
        gt -= 1; //gt moves down one
      }
    }

    int[] ans = {1,0};
    return ans;
  }

  public static int median(int[] data, int a, int b, int c) {
    int dataA = data[a];
    int dataB = data[b];
    int dataC = data[c];
    if (dataA < dataB) {
      if (dataA <= dataC && dataC <= dataB) {
        return c;
      } else if (dataC < dataA) {
        return a;
      } else {
        return b;
      }
    } else {
      if (dataB <= dataC && dataC <= dataA) {
        return c;
      } else if (dataC < dataB) {
        return b;
      } else {
        return a;
      }
    }
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

  public static void quicksort(int[] data) {
    quicksortH(data, 0, data.length - 1);
  }

  //Sorts the entire array
  public static void quicksortH(int[] data, int start, int end) {
    if (start >= end || start < 0) {
      return;
    }
    int pivot = partition(data, start, end);
    quicksortH(data, start, pivot - 1);
    quicksortH(data, pivot + 1, end);
  }
}
