package org.example;



import org.example.Exception.IncorrectIndexException;
import org.example.Exception.NullItemInputException;
import org.junit.Test;


import static org.junit.Assert.*;


public class StringListImplTest {
    StringList s = new StringListImpl();

    @Test
    public void testAdd() {
        String expected = "one";

        String actual = s.add("one");

        assertEquals(expected, actual);

    }

    @Test
    public void testTestAdd() {
        String item = "two";
        int index = 0;


        String expected = item;
        String actual = s.add(index, item);

        assertEquals(expected, actual);
    }

    @Test
    public void addIndexException() {
        String item = "two";
        int index = 4;



        String expected = "Введён некорректный индекс";
        Exception exception = assertThrows(
                IncorrectIndexException.class,
                () -> {
                    s.add(index, item);
                }
        );

        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testSet() {
        String item = "two";
        int index = 0;



        String expected = item;
        String actual = s.set(index, item);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveItem() {
        String item = "1";
        String expected = item;

        s.add(item);
        String actual = s.remove(item);
        assertEquals(expected, actual);
    }

    @Test
    public void removeItemException() {
        String item = null;



        String expectedResult = "Введён пустой запрос";
        Exception exception = assertThrows(
                NullItemInputException.class,
                () -> {
                    s.remove(item);
                }
        );

        assertEquals(expectedResult, exception.getMessage());
    }

    @Test
    public void testTestRemoveIndex() {
        String item = "two";
        int index = 0;
        String expectedString = item;

        s.add(item);
        String actualString = s.remove(index);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testRemoveIndexException() {
        String item = "two";

        s.add(item);
        int index = 6;

        String expected = "Введён некорректный индекс";
        Exception exception = assertThrows(
                IncorrectIndexException.class,
                () -> {
                    s.remove(index);
                }
        );

        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testContains() {
        s.add("one");
        s.add("two");

        assertTrue(s.contains("two"));
    }
    @Test
    public void testIndexOf() {
        s.add("one");
        s.add("two");
        int expected = 1;

        int actual = s.indexOf("two");
        assertEquals(expected, actual);
    }
    @Test
    public void testIndexOfFail() {
        s.add("one");
        s.add("two");
        int expected = -1;

        int actual = s.indexOf("three");
        assertEquals(expected, actual);
    }
    @Test
    public void testLastIndexOf() {
        s.add("one");
        s.add("two");
        int expected = 1;

        int actual = s.lastIndexOf("two");
        assertEquals(expected, actual);
    }
    @Test
    public void testLastIndexOfFail() {
        s.add("one");
        s.add("two");
        int expected = -1;

        int actual = s.lastIndexOf("three");
        assertEquals(expected, actual);
    }
    @Test
    public void testGet() {
        String expected = "one";

        s.add("one");

        String actual = s.get(0);

        assertEquals(expected, actual);
    }
    @Test
    public void testGetFail() {
        String item = "two";

        s.add(item);
        int index = 6;

        String expected = "Введён некорректный индекс";
        Exception exception = assertThrows(
                IncorrectIndexException.class,
                () -> {
                    s.get(index);
                }
        );

        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testTestEquals() {
        String[] test = {"one", "two", "three"};

        s.add("one");
        s.add("two");
        s.add("three");


        assertEquals(test[0], s.get(0));
        assertEquals(test[1], s.get(1));
        assertEquals(test[2], s.get(2));
    }

    @Test
    public void testSize() {
        s.add("one");
        s.add("two");
        int expected = 2;

        int actual = s.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        boolean expected = true;
        boolean actual = s.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        s.add("one");
        s.add("two");
        s.clear();
        assertTrue(s.isEmpty());

    }

}