package ru.patterns.behavioral.iterator;

import ru.patterns.behavioral.iterator.my.MyIterable;
import ru.patterns.behavioral.iterator.my.MyIterator;

import java.util.ArrayList;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class PancakeHouseMenu implements MyIterable<MenuItem> {
    ArrayList<MenuItem> items;

    public PancakeHouseMenu() {
        items=new ArrayList<MenuItem>();
        this.addItem("abc1","qwe",true,2);
        this.addItem("abc2","zxc",false,2);
    }

    public void addItem(String name, String description, boolean vegetable, double price){
        items.add(new MenuItem(name,description,vegetable,price));
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public MyIterator<MenuItem> getIterator() {
        return new PancakeIterator();
    }

    private class PancakeIterator implements MyIterator<MenuItem>{
        private int current=0;
        public boolean hasNext() {
            return current!=items.size();
        }

        public MenuItem next() {
            return items.get(current++);
        }
    }
}
