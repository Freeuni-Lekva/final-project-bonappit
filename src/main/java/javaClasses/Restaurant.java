package javaClasses;

public class Restaurant {
    String name;
    String id;
    String menu;
    int numTable;
    double rating;
    public Restaurant(String name,String id,String menu,int numTable,double rating){
        this.name=name;
        this.id=id;
        this.menu=menu;
        this.numTable=numTable;
        this.rating=rating;
    }
    public String getName(){return name;}
    public String getId(){return id;}
    public String getMenu(){return menu;}
    public int getNumTable(){return numTable;}
    public double getRating(){return rating;}

}
