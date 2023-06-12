import java.util.Date;
import java.text.*;

/**
 * ToDo class. This class represents a ToDo. Has basic attributes and functionality of a ToDo.
 * Author: Jeslyn Haq.
 */

public class ToDo{
    private String title;
    private boolean isComplete;
    private Date dueDate;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * Constructor of the ToDo Class.
     * @param  title  a title of the ToDo
     * @param  isCompelte  a boolean indicating whether the ToDo is complete or not.
     * @param  dueDate  a Date representing the due date of this ToDo
     * @return      void
     */
    public ToDo(String title, boolean isComplete, Date dueDate) {
        this.title = title;
        this.isComplete = isComplete;
        this.dueDate = dueDate;
    }

    /**
     * Marks the ToDO as complete.
     * @return      void
     */
    public void markComplete() {
        isComplete = true;
    }

    /**
     * Marks the ToDO as incomplete.
     * @return      void
     */
    public void markIncomplete() {
        isComplete = false;
    }

    /**
     * Returns the title of the ToDo
     * @return      A string representing the title of the ToDo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the due date of the ToDo
     * @return      A Date representing the due date of the ToDo
     */
    public Date getDate() {
        return dueDate;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(Date date){
        this.dueDate = date;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * Returns a string representing the ToDo class.
     * @return      A string representing the ToDo class.
     */
    @Override
    public String toString() {
        return "Title: " + title + "\nDue Date: " + dateFormat.format(dueDate);
    }
}