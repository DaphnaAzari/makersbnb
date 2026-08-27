package com.makers.makersbnb.model;

import jakarta.persistence.*;

// @Entity - instances of this class map to database records
@Entity
// @Table - those records can be found in the spaces table
@Table(name = "spaces")
public class Space {

    // the following field (id) is the primary key for this Entity
    @Id
    // the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // a second field that holds the name of each space
    private String name;
    private String description;
    private String rules;
    //double for price because it matches
    // how I'm storing it as a decimal in the database:
    private double price;


    //How can there be two constructors? In Java, a method is identified by both its name and parameters.
    // So you can have multiple methods with the same name, providing their parameters are different.
    // This feature is called "method overloading" and it's super useful.
    // a zero-arguments constructor

    public Space() {}


    // a one-argument constructor
    public Space(String name) {
        this.name = name;
    }

    // methods that get and set name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description =description;
    }
     public double getPrice() { return this.price; }
     public void setPrice(double price) {
       this.price = price;
  }

    public String getRules() {return this.rules;}
    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
