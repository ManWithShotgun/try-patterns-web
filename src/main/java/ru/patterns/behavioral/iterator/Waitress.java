package ru.patterns.behavioral.iterator;

import ru.patterns.behavioral.iterator.my.MyIterator;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class Waitress {
    private PancakeHouseMenu pancakeHouseMenu;
    private DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu(){
        this.printMenu(pancakeHouseMenu.getIterator());
        this.printMenu(dinerMenu.getIterator());
    }

    private void printMenu(MyIterator myIterator){
        while (myIterator.hasNext()){
            MenuItem menuItem= (MenuItem) myIterator.next();
            System.out.println(menuItem.getName()+" "+menuItem.getPrice());
        }
    }
}
