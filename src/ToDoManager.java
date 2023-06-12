import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.text.*;
/**
 * ToDoManager class. This class provides functionality to manager ToDos.
 * Author: Jeslyn Haq.
 */

public class ToDoManager{
    private ArrayList<ToDo> listOfToDos;
    private String toDoStroageFileName;


    /**
     * Default constructor of the class.
     * Just initializes an empty list of todos.
     */
    public ToDoManager(){
        listOfToDos = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new File("data.txt"));
            while (fileIn.hasNext()) {
                // Read the  string
                String raw = fileIn.nextLine();
                // Split on ,
                String[] arr = raw.split("\\,");
                // First entry is name
                String title = arr[0];
                Date dueDate = new Date();
                try {
                    dueDate = ToDo.dateFormat.parse(arr[1]);
                } catch(ParseException e) {
                    System.out.println("Date format is invalid. Please try with correct date");
                }
                Boolean isComplete = false;
                try{
                    isComplete = Boolean.parseBoolean(arr[2]);
                }
                catch (Exception e) {
                    System.out.println("Boolean format is invalid. Please try with correct date");
                }
                ToDo toDo = new ToDo(title, isComplete, dueDate);
                // Add to the roster
                listOfToDos.add(toDo);
            }
            fileIn.close();
        }
        catch (IOException e) {
            System.out.println("No List Exists.");
        }
    }

    /**
     * Returns a list of all ToDo's.
     * @return      An ArrayList of ToDos.
     */
    public ArrayList<ToDo> getAllToDos(){
        ArrayList<ToDo> output = listOfToDos;
        return output;
    }

    public Object[] getAllToDosTitle(){
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < listOfToDos.size(); i++){
            output.add(listOfToDos.get(i).getTitle());
        }
        return output.toArray();
    }

    /**
     * Returns a list of all incomplete ToDo's.
     * @return      An ArrayList of ToDos.
     */
    public ArrayList<ToDo> getIncompleteToDos(){
        ArrayList<ToDo> output = listOfToDos;
        return output;
    }

    /**
     * Returns a list of all ToDo's.
     * @return      An ArrayList of ToDos.
     */
    public ArrayList<ToDo> getCompleteToDos(){
        ArrayList<ToDo> output = listOfToDos;
        return output;
    }

    public ToDo getToDoAtIndex(int i){
        return listOfToDos.get(i);
    }

    public void saveAllToDos() {
        try {
            PrintWriter fileOut = new PrintWriter("data.txt");
            for(int i = 0; i < listOfToDos.size(); i++){
                ToDo toDo = listOfToDos.get(i);
                // add the title
                fileOut.print(toDo.getTitle());
                // add the date
                fileOut.print("," + ToDo.dateFormat.format(toDo.getDate()));
                // add iscomplete
                fileOut.print("," + toDo.getIsComplete());
                fileOut.println();
            }
            fileOut.close();
        }
        catch (IOException e) {
            System.out.println("Unable to write");
        }
    }

    public void updateToDo(int index, String title, boolean isComplete, Date dueDate) {
        if (index <0 || index > listOfToDos.size()) {
            return;
        }
        ToDo toDo = listOfToDos.get(index);
        toDo.setTitle(title);
        toDo.setDueDate(dueDate);
        toDo.setComplete(isComplete);

    }

    /**
     * Adds a ToDo.
     * @param  title  a title of the ToDo to be added
     * @param  isCompelte  a boolean indicating whether the ToDo is complete or not.
     * @param  dueDate  a Date representing the due date of this ToDo
     * @return      void
     */
    public void addToDo(String title, boolean isComplete, Date dueDate){
        ToDo toDo = new ToDo(title, isComplete, dueDate);
        listOfToDos.add(toDo);
    }

    /**
     * Find ToDos by a title. This function searches all the ToDo's and returns a list containing the ToDos with matching title.
     * @param  title  a search string for searching the todo titles.
     * @return      An ArrayList containing the ToDo's that matched the given title. The Arraylist will be empty if no ToDo's matched the string.
     */
    public ArrayList<ToDo> findToDo(String title) {
        ArrayList<ToDo> result = new ArrayList<ToDo>();
        String searchKey = "(.*)"+title.toUpperCase()+"(.*)";
        for(int i = 0; i < listOfToDos.size(); i++){
            if (listOfToDos.get(i).getTitle().toUpperCase().matches(searchKey)){
                result.add(listOfToDos.get(i));
            }
        }
        return result;
    }

    /**
     * Sorts the list of Todos in ascending order of Due Date.
     * @return      ArrayList containing the ToDo's in sorted order.
     */
    public ArrayList<ToDo> sortToDos() {
        listOfToDos.sort(new ToDoComparator());
        return listOfToDos;
    }

}