package javaClasses;

import java.util.ArrayList;

public class Reservation {
    String username;
    ArrayList<String> menu;
    double price;
    boolean status;
    public Reservation(String username,ArrayList<String> menu,double price,boolean status){
        this.username=username;
        this.menu=menu;
        this.price=price;
        this.status=false;
    }
    public void reject(){
        status=true;
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
    //false=accepted  true=rejected
    public boolean getStatus(){return status;}

    public String getStringStatus(){
        if (status) return "ACCEPTED";
        return  "AWAITING";
    }
}
