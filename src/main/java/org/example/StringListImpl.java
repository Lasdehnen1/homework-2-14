package org.example;


import org.example.Exception.FullArrayException;
import org.example.Exception.IncorrectIndexException;
import org.example.Exception.NullItemInputException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] storage;

    private int size;

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    private void validateInput(String item) {
        if( item == null ) {
            throw new NullItemInputException("Введён пустой запрос");
        }
    }

    private void validateInput(int index) {
        if(index < 0 || index > size) {
            throw new IncorrectIndexException("Введён некорректный индекс");
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new FullArrayException("Массив переполнен");
        }
    }

    @Override
    public String add(String item) {
        validateSize();
        validateInput(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateInput(item);
        validateSize();
        validateInput(index);


        if (index == size) {
            storage[size++] = item;
            return item;
        }

        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateInput(index);
        validateInput(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateInput(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateInput(index);
        String item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {

        for (int i = 0; i < size; i++) {
            if(storage[i].equals(item)) {
                return i;
            }
            
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if(storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateInput(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }


}
