public class oops {
    public static void main(String[] args) {
        // Pen p1=new Pen();
        // p1.setColor("blossom");
        // System.out.println(p1.getColor());
        // p1.setColor("light");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        //
        // Student s1=new Student();
        // s1.name="shradha";
        // s1.roll=456;
        // s1.password="abcd";
        // s1.marks[0]=100;
        // s1.marks[1]=90;
        // s1.marks[2]=80;
        // Student s2=new Student(s1);
        // s2.password="xyz";
        // s1.marks[2]=100;
        // for(int i=0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }
        //
        // Fish shark=new Fish();
        // shark.eat();
        // Dog dogesh=new Dog();
        // dogesh.eat();
        // dogesh.legs=4;
        // System.out.println(dogesh.legs);
        // Horse h=new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // Mustang myHorse=new Mustang();
        // Queen q=new Queen();
        // q.moves();
        // Bear b=new Bear();
        // b.eatFish();
        // b.eatHoney();
    }
}
interface Herbivore{
    void eatHoney();
}
interface Carnivore{
    void eatFish(); 
}
class Bear implements Herbivore,Carnivore{
    public void eatHoney(){
        System.out.println("Eating honey");
    }
    public void eatFish(){
        System.out.println("Eating fish");
    }
}




interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(in all 4 directions)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}


// abstract class Animal{
//     String color;
//     Animal(){
//         // color="brown";
//         System.out.println("Animal constructor called");
//     }
//     void eat(){
//         System.out.println("animal eats");
//     }
//     abstract void walk();
// }

// class Horse extends Animal{
//     Horse(){
//         System.out.println("Horse constructor called");
//     }
//     void changeColor(){
//         color="dark brown";
//     }
//     void walk(){
//         System.out.println("walks on 4 legs");
//     }
// }
// class Mustang extends Horse{
//     Mustang(){
//         System.out.println("Mustang constructor called");
//     }
// }




// class Animal{
//     String color;
//     void eat(){
//         System.out.println("eats");
//     }
//     void breathe(){
//         System.out.println("breathes");
//     }
}
// class Mammal extends Animal{
//     void walk(){
//         System.out.println("walks");
//     }
// }
// class Dog extends Animal{
//     void bark(){
//         System.out.println("bho bho");
//     }
// }
// class Fish extends Animal{
//     void swim(){
//         System.out.println("swims");
//     }
// }

// class Dog extends Mammal{
//     String breed;
// }
// class Fish extends Animal{
//     int fins;
//     void swim(){
//         System.out.println("swims in water");
//     }
// }

// class Student{
//     String name;
//     int roll;
//     String password;
//     int marks[];
    
    //shallow copy constructor
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }

    //deep copy constructor
//     Student(Student s1){
//         marks=new int[3];
//         this.name=s1.name;
//         this.roll=s1.roll;
//         for(int i=0;i<marks.length;i++){
//             this.marks[i]=s1.marks[i];
//         }
//     }

//     Student(){
//         marks=new int[3];
//         System.out.println("Constructor is called!");
//     }
//     Student(String name){
//         marks=new int[3];
//         this.name=name;
//     }
//     Student(int roll){
//         marks=new int[3];
//         this.roll=roll;
//     }
// }

// class Pen{
//     private String color;
//     private int tip;    

//     String getColor(){
//         return this.color;
//     }
//     int getTip(){
//         return tip;
//     }

//     void setColor(String newColor){
//         color=newColor;
//     }
//     void setTip(int newTip){
//         tip=newTip;
//     }
// }