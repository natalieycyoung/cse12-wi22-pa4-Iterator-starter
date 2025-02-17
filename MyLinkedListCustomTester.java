
/**
 * Name: Natalie Young
 * ID: A17237090
 * Email: nyoung@ucsd.edu
 * Sources used: zybooks, Lecture Slides
 * 
 * Contains class that contains many JUnit tests for MyLinkedList
 * and the class ListIterator within the file
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: Tests MyLinkedList with other cases
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        listLen1 = new MyLinkedList();
        listLen1.add("Natalie");
        listLen1Iter = listLen1.new MyListIterator();

        listLen2 = new MyLinkedList();
        listLen2.add("Ya-chu");
        listLen2.add("Young");
        listLen2Iter = listLen2.new MyListIterator();
    }

    /**
     * TODO: test the hasNext method when [fill in a possible edge case here]
     */
    @Test
    public void testHasNext() {

    }

    /**
     * TODO: test the next method when [...]
     */
    @Test
    public void testNext() {

    }

    /**
     * TODO: test the hasPrevious method when [fill in another one here]
     */
    @Test
    public void testHasPrevious() {

    }

    /**
     * TODO: test the previous method when [...]
     */
    @Test
    public void testPrevious() {

    }

    /**
     * TODO: test the nextIndex method when [...]
     */
    @Test
    public void testNextIndex() {

    }

    /**
     * TODO: test the previousIndex method when [...]
     */
    @Test
    public void testPreviousIndex() {

    }

    /**
     * TODO: test the set method when [...]
     */
    @Test
    public void testSet() {

    }

    /**
     * TODO: test the remove method when [...]
     */
    @Test
    public void testRemoveTestOne() {

    }

    /**
     * TODO: test the remove method when [fill in another one here]
     */
    @Test
    public void testRemoveTestTwo() {

    }

    /**
     * TODO: test the add method when [...]
     */
    @Test
    public void testAdd() {

    }

}
