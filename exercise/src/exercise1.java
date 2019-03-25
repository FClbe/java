import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

import  java.util.*;

public class exercise1
{
    public  static void  main(String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 1, 4, 1, 5, 9, 2, 6};
        showReversedArray(array1);
        showReversedArray(array2);
    }
    public static  void showReversedArray(int[] a)
    {
        Arrays.sort(a);
        int temp;
        int count = a.length;
        for(int i = 0; i < count/2; i++ )
        {
            temp = a[i];
            a[i] = a[count - 1 - i];
            a[count - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}

