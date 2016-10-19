package ru.patterns.behavioral.iterator.my;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public interface MyIterator<T> {

    boolean hasNext();

    T next();
}
