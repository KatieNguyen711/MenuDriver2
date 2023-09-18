import java.util.NoSuchElementException;
import java.util.ArrayList;
 
/**
 * Doubly Linked list 
 * </p>
 * originally pulled from OpenDSA Data Structures and Algorithms Modules Collection, CHAPTER 9 LINEAR STRUCTURES
 * all methods edited to work without header and trailer
 * </p>
 * 
 * @see https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/ListDouble.html
 * @author Katie Nguyen
 * @version 1.5, 09/12/2023
 * 
 */
 
// Linked list implementation
public class BasicDLList<E> implements List<E>{
    private Link<E> head;      // Pointer to list header
    private Link<E> tail;      // Pointer to last element
    private Link<E> curr;      // Access to current element
    private Link<E> holder;    //extra pointer for organization
    private int listSize;      // Size of list
    private StringBuffer output;   //holds output for 
    
    /**
    *Constructor that asks for size
    *
    *@param size
    */

    // Constructors
    BasicDLList(int size) {      // Constructor -- Ignore size
        this();
    }
    /**
    *Constructor that calls clear()
    *
    *@see clear()
    */
    BasicDLList() {
        clear();
    }
    /**
    *Removes all elements
    *</p>
    *sets curr, tail, and head pointer to null
    *initializes listSize and output
    *</p>
    *
    */
    public void clear() {
        curr= null;
        tail = null;
        head = null;
        holder = null;
        listSize = 0;
        output = new StringBuffer();
    }
    /**
     * inserts it into current position
     * 
     * @param it
     * @return true when element is added
     */
    public boolean insert(E it){
        //if theres nothing in the list
        if(listSize==0){
            curr=head=tail =new Link<E>(it, null, null); //creates one node
        }else{
            //if curr is at the start
            if (curr==head){
                curr= head= new Link (it, curr.prev(), curr);
                curr.next().setPrev( curr );
            }//it curr is at the end
            else if(curr == null){
                holder = tail.setNext(new Link( it, tail, null ));
                tail=holder;
                curr=holder;
                curr.prev().setNext(tail);
            }else{
                holder = new Link (it, curr.prev(), curr);
                curr=holder;
                curr.prev().setNext( curr );
                curr.next().setPrev( curr );
            }
        }
        listSize++;
        
        return true;
    }
    /**
     * Add "it" to the end of the list
     * 
     * @param it
     * @return true when element is added
     */
    public boolean append(E it){
        //if there is nothing in the list
        if(listSize ==0){
            curr=head=tail =new Link<E>(it, null, null);
        }else{
            //if theres one element in the list
            if(listSize==1){
                tail=head.setNext(new Link( it, head, null ));
            }else{
                holder = tail.setNext(new Link( it, tail.prev(), null ) );
                tail = holder;
                tail.prev().setNext( tail );
            }
        }
        listSize++;
        return true;
    }
 
    /**
     * Remove and return current element
     * 
     * @return the value that was removed
     */
    public E remove () throws NoSuchElementException {
        E it = curr.element();  // Remember value
        //if there is one element
        if(listSize ==1){
            curr=head=tail=null;
        }//if curr is at tail
        else if( curr == tail ){
            curr.prev().setNext(null);
            curr=tail=curr.prev();
        }//if curr is at head
        else if(curr==head){
            curr.next().setPrev(null);
            curr=head=curr.next();
        }else{
            curr.prev().setNext( curr.next() );
            curr.next().setPrev( curr.prev() );
            curr = curr.next();
        }
        listSize--;  // Decrement node count
        return it;  // Return value removed
    }
    /**
     * Set curr at list start
     * 
     */
    public void moveToStart() {
        curr = head; 
    }
    /**
     * Set curr at the end of the list
     * 
     */
    public void moveToEnd() {
        //curr = null means that curr is at end of the list
        curr=null;
    }
    /**
     * Move curr one step left; no change if now at front
     * 
     */
    public void prev() {
        //if head.prev() == null, it is the beginning
        //if curr is at the end
        if(curr==null){
            curr=tail;
        }//if curr is at the beginning
        else if( curr==head){
            return ;
        }//if prev has an element 
        else if (curr.prev()!=null) {
            curr = curr.prev();
        }
    }
    /**
     * Move curr one step right; no change if now at end
     * 
     */
    public void next() { 
        //if tail.next() == null, it is the end
        //if curr is at end
        if(curr==null){
            return ;
        }//if curr is at tail
        else if (curr==tail){
            curr=null;
        }//if next has an element
        else if (curr.next() != null) { 
            curr = curr.next();
        }
    }
    /**
     * Return list length
     * 
     * @return list size
     */
    public int length() { return listSize; } 
    /**
     * Return the position of the current element
     * 
     * @return position of current element
     */
    public int currPos() {
        Link<E> temp = head;
        int i;
        //if theres only 1 element
        if(listSize==1){
            return 0;
        }//if curr is at the end
        else if(curr==null){
            return listSize;
        }else{
            for (i=0; temp != curr; i++) {
                temp = temp.next();
            }
            return i;
        }
    }
    /**
     * Move up list to "pos" position
     * 
     * @param pos position
     * @return false if pos is < or > listSize; true if curr is set to pos
     */
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) {
            return false;
        }
        
        curr = head;
        if(pos==listSize){
            curr=null;
        }else{
            for(int i=0; i<pos; i++) { 
                curr = curr.next(); 
            }  
        }
        
        return true;
    }
    /**
     * Return true if current position is at end of the list
     * 
     * @return true if curr is null; false if not
     */
    public boolean isAtEnd() { return curr == null; }
    /**
     * Return current element value
     * 
     * @return value of curr
     */
    public E getValue() throws NoSuchElementException {
        //if theres only 1 element
        if(listSize==1){
            return head.element();
        }//if curr is at end
        else if(curr==null){
            return null;
        }else{
            return curr.element();
        }
    }
    /**
     * Tell if the list is empty or not
     * 
     * @return true if listSize is 0; false if not
     */
    public boolean isEmpty() {
        return listSize == 0;
    }
    /**
     * Returns a String of what is currently in the linked lists
     * 
     * @return String of list
     */
    public String toString(){
        //makes output empty
        if(output.length()!=0){
            output.delete(0, output.length());
        }
        
        Link<E> temp = head;
        output.append(temp.element());
        temp = temp.next();
        //if theres only 1 element
        if(listSize==1){
            return output.toString();
        }
        
        //else
        for(int i=1; i<listSize; i++) { 
            if(temp==null){
                return output.toString();
            }
            output.append(", ");
            output.append(temp.element());
            temp = temp.next(); 
        }
    
        return output.toString();
    }
}