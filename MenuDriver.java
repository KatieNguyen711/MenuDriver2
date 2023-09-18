import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * This will allow user to input any String and move, remove, or add Strings to a lDoubly Linked List.
 *
 * @author Katie Nguyen
 * @version 2.5, 9/12/2023
 */
public class MenuDriver
{
    public static void main(String[] args){
        String answer = "";    //answer holds user's inputs
        int position = 0;     //holds current position
        Scanner text = new Scanner(System.in);   //asks user for input
        BasicDLList<String> list2 = new BasicDLList<String>();  
        
        
        //Welcome message and list of options
        System.out.println("909469912");
        System.out.println("Welcome to the Menu Driver for a bare bones list!");
        System.out.println("");
        System.out.println("Command options: ");
        System.out.println("I string_to_insert  (insert a string at the current position)");
        System.out.println("A string_to_append  (append a string at the end)");
        System.out.println("R  (remove the string at the current position)");
        System.out.println("S  (move the current position to the start)");
        System.out.println("E  (move the current position to the end)");
        System.out.println("P  (move the current position backward)");
        System.out.println("F  (move the current position forward)");
        System.out.println("L  (display the length of the list)");
        System.out.println("C  (display the current position number)");
        System.out.println("M number  (move the current position to specific position)");
        System.out.println("D  (display the string at the current position)");
        System.out.println("V  (display all strings)");
        System.out.println("O  (display these options)");
        System.out.println("Q  (quit)");
        System.out.println("");
        
        while(!(answer.equals("Q"))){
            System.out.println("Please enter a command (or 'O' for all of the options): ");
            answer = text.nextLine();
            //checks if input is valid (if not A, I, M)
            if (answer.length()==1){
                //R
                if (answer.equals("R")){
                    System.out.println("Removing the string at the current position ...");
                    System.out.println("Removed '" + list2.remove() + "'");
                    
                }//S
                else if(answer.equals("S")){
                    System.out.println("Moving the current position to the start ...");
                    list2.moveToStart();
                }//E
                else if (answer.equals("E")){
                    System.out.println("Moving the current position to the end ...");
                    list2.moveToEnd();
                }//P
                else if (answer.equals("P")){
                    System.out.println("Moving the current position backward ...");
                    list2.prev();
                }//F
                else if (answer.equals("F")){
                    System.out.println("Moving the current position forward ...");
                    list2.next();
                }//L
                else if (answer.equals("L")){
                    System.out.println("Displaying the length of the list ...");
                    System.out.println(list2.length());
                }//C
                else if (answer.equals("C")){
                    System.out.println("Displaying the current position number ...");
                    System.out.println(list2.currPos());
                }//D
                else if (answer.equals("D")){
                    System.out.println("Displaying the string at the current position  ...");
                    System.out.println(list2.getValue());
                }//V
                else if(answer.equals("V")){
                    System.out.println(list2.toString());
                }//O
                else if (answer.equals("O")){
                    System.out.println("Command options: ");
                    System.out.println("I string_to_insert  (insert a string at the current position)");
                    System.out.println("A string_to_append  (append a string at the end)");
                    System.out.println("R  (remove the string at the current position)");
                    System.out.println("S  (move the current position to the start)");
                    System.out.println("E  (move the current position to the end)");
                    System.out.println("P  (move the current position backward)");
                    System.out.println("F  (move the current position forward)");
                    System.out.println("L  (display the length of the list)");
                    System.out.println("C  (display the current position number)");
                    System.out.println("M number  (move the current position to specific position)");
                    System.out.println("D  (display the string at the current position)");
                    System.out.println("V  (display all strings)");
                    System.out.println("O  (display these options)");
                    System.out.println("Q  (quit)");
                    System.out.println("");
                }//Q
                else if (answer.equals("Q")){
                    System.out.println("");
                }else{
                    System.out.println(answer + " is not a valid command!");
                }
            }//if input is A, I, M
            else{
                //A
                if (answer.indexOf("A")==0){
                    System.out.println("Appending '" + answer.substring(2) + "' ...");
                    //list2.append(answer.substring(2));
                    //uses insert
                    position = list2.currPos();
                    list2.moveToPos(list2.length());
                    list2.insert(answer.substring(2));
                    list2.moveToPos(position);
                }//I
                else if (answer.indexOf("I")==0){
                    System.out.println("Inserting '" + answer.substring(2)+ "' ...");
                    list2.insert(answer.substring(2));
                }// M
                else if (answer.indexOf("M")==0){
                    System.out.println("Moving current position to " + Integer.parseInt(answer.substring(2)) +" ...");
                    //if moveToPos is false
                    if (list2.moveToPos(Integer.parseInt(answer.substring(2)))==false){
                        System.out.println("Failed to move!");
                    }else{
                        list2.moveToPos(Integer.parseInt(answer.substring(2)));
                        System.out.println("Successfully moved position!");
                    }
                }// if input is invalid
                else {
                    System.out.println(answer + " is not a valid command!");
                }
            }
            System.out.println("");
        }
        
        System.out.println("Good-bye");
    }
}
