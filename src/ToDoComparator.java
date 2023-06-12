import java.util.Comparator;
import java.util.Date;

/**
 * ToDoComparator class. This class is used to impelment a comparator of two ToDo's.
 * Author: Jeslyn Haq.
 */
public class ToDoComparator implements Comparator<ToDo> {

    /**
     * Compares two ToDos.
     * @param  a  first ToDo to compare.
     * @param  b  second ToDo to compare
     * @return      int ( negative number if a < b, 0 if a==b, positive number if a>b)
     */
    @Override
    public int compare(ToDo a, ToDo b) {
        Date aDate = a.getDate();
        Date bDate = b.getDate();
        int ret = aDate.compareTo(bDate);
        return ret;
    }
}