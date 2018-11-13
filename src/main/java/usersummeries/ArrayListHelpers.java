package usersummeries;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListHelpers
{
    public static <T> void insertSorted(List<T> list, T item, Comparator<T> comparator)
    {
        int index = Collections.binarySearch(list, item, comparator);
        if (index < 0)
        {
            index = ~index;
        }

        list.add(index, item);
    }
}
