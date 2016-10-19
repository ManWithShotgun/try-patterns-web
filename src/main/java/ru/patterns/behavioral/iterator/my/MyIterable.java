package ru.patterns.behavioral.iterator.my;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public interface MyIterable<T> {
    MyIterator<T> getIterator();
}
