import java.util.*;

public class exercisse2
{
    public static void main (String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 4};
        int[] array2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 3, 9};
        int[] array3 = {1, 1, 1, 1};
        showNonDuplicateArray(array1);
        showNonDuplicateArray(array2);
        showNonDuplicateArray(array3);

    }
    public static void showNonDuplicateArray(int[] a)
    {
        int count = a.length;
        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count ; j++) {
                if (a[i] == a[j])
                {    if(i == count - 2)
                       a[j] = 0;
                else
                    for (int k = 0; k < count - 1 - j; k++) {
                        a[j] = a[j + 1];
                    }
                    a = Arrays.copyOf(a, a.length-1);
                    count--;
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
