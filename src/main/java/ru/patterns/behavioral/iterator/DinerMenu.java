package ru.patterns.behavioral.iterator;

import ru.patterns.behavioral.iterator.my.MyIterable;
import ru.patterns.behavioral.iterator.my.MyIterator;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class DinerMenu implements MyIterable<MenuItem> {
    static final int MAX_ITEMS=10;
    int numberOfItems=0;
    MenuItem[] items;

    public DinerMenu() {
        items= new MenuItem[MAX_ITEMS];

        this.additem("qwe3","dasd",false,4);
        this.additem("qwe4","ffffd",false,4);
    }

    public void additem(String name, String description, boolean vegetable, double price){
        MenuItem menuItem=new MenuItem(name,description,vegetable,price);
        if(numberOfItems>=MAX_ITEMS){
            System.err.println("So much items");
        }else {
            items[numberOfItems]=menuItem;
            numberOfItems++;
        }
    }

    public MenuItem[] getItems() {
        return items;
    }

    public MyIterator<MenuItem> getIterator() {
        return new DinerIterator();
    }

    private class DinerIterator implements MyIterator<MenuItem>{
        private int current=0;
        public boolean hasNext() {
            return current!=numberOfItems;
        }

        public MenuItem next() {
            return items[current++];
        }
    }
}
