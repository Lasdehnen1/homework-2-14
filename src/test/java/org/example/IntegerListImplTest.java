package org.example;



import org.example.Exception.IncorrectIndexException;
import org.example.Exception.NullItemInputException;
import org.junit.Test;


import static org.junit.Assert.*;


public class IntegerListImplTest {
    IntegerList s = new IntegerListImpl();

    @Test
    public void testAdd() {
        Integer expected = 1;

        Integer actual = s.add(1);

        assertEquals(expected, actual);

    }

    @Test
    public void testTestAdd() {
        Integer item = 2;
        int index = 0;


        Integer expected = item;
        Integer actual = s.add(index, item);

        assertEquals(expected, actual);
    }

    @Test
    public void addIndexException() {
        Integer item = 2;
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
        Integer item = 2;
        int index = 0;



        Integer expected = item;
        Integer actual = s.set(index, item);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveItem() {
        Integer item = 1;
        Integer expected = item;

        s.add(item);
        Integer actual = s.remove(item);
        assertEquals(expected, actual);
    }

    @Test
    public void removeItemException() {
        Integer item = null;



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
        Integer item = 2;
        int index = 0;
        Integer expected = item;

        s.add(item);
        Integer actual = s.remove(index);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveIndexException() {
        Integer item = 2;

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
        s.add(1);
        s.add(2);

        assertTrue(s.contains(2));
    }
    @Test
    public void testIndexOf() {
        s.add(1);
        s.add(2);
        int expected = 1;

        int actual = s.indexOf(2);
        assertEquals(expected, actual);
    }
    @Test
    public void testIndexOfFail() {
        s.add(1);
        s.add(2);
        int expected = -1;

        int actual = s.indexOf(3);
        assertEquals(expected, actual);
    }
    @Test
    public void testLastIndexOf() {
        s.add(1);
        s.add(2);
        int expected = 1;

        int actual = s.lastIndexOf(2);
        assertEquals(expected, actual);
    }
    @Test
    public void testLastIndexOfFail() {
        s.add(1);
        s.add(2);
        int expected = -1;

        int actual = s.lastIndexOf(3);
        assertEquals(expected, actual);
    }
    @Test
    public void testGet() {
        Integer expected = 1;

        s.add(1);

        Integer actual = s.get(0);

        assertEquals(expected, actual);
    }
    @Test
    public void testGetFail() {
        Integer item = 2;

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
        Integer[] test = {1, 2, 3};

        s.add(1);
        s.add(2);
        s.add(3);


        assertEquals(test[0], s.get(0));
        assertEquals(test[1], s.get(1));
        assertEquals(test[2], s.get(2));
    }

    @Test
    public void testSize() {
        s.add(1);
        s.add(2);
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
        s.add(1);
        s.add(2);
        s.clear();
        assertTrue(s.isEmpty());

    }



}