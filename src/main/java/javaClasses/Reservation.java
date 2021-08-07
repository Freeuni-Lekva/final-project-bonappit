package javaClasses;

import java.util.ArrayList;

public class Reservation {
    String username;
    ArrayList<String> menu;
    double price;
    boolean rejected;
    public Reservation(String username,ArrayList<String> menu,double price,boolean rejected){
        this.username=username;
        this.menu=menu;
        this.price=price;
        this.rejected=false;
    }
    public void reject(){
        rejected=true;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public ArrayList<String> getMenu(){
        return menu;
    }
    public void addToMenu(String food,double price){
        menu.add(food);
        this.price=this.price+price;
    }
    public void removeFromMenu(String food,double price){
        menu.remove(food);
        this.price=this.price-price;
    }
    public void  replaceMenu(ArrayList<String> menu,double price){
        this.menu=menu;
        this.price=price;
    }
}
