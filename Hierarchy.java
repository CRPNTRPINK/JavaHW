import java.util.ArrayList;
class View{
    public static void main(String[] args){
        Ball shar = new Ball(5);
        System.out.print("Объем шара - " + shar.getVolume());
        Cylinder cyl = new Cylinder(5, 10);
        System.out.print("\nОбъем цилиндра - " + cyl.getVolume());
        Pyramid pyr = new Pyramid(10, 5);
        System.out.print("\nОбъем пирамиды - " + pyr.getVolume());
        Box bo = new Box(100000);
        System.out.print("\n" + bo.add(pyr));

    }
}

class Shape {
    private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class SolidOfRevolution extends Shape {
    private double radius;

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Ball extends SolidOfRevolution { // конкретный класс
    public Ball(double radius) {
        super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;
    public Cylinder(double radius, double height){
        super(Math.PI * Math.pow(radius, 2) * height, radius);
        this.height = height;
    }
}

class Pyramid extends Shape {
    private double S; //Площадь основания
    private double h; //Высота
    public Pyramid(double S, double h){
        super((S * h) * 1 / 3); //задать вопрос
        this.S = S;
        this.h = h;
    }
}

class Box extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;

    public Box(double available) {
        super(available);
        this.available = available;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }
}

//АБСТРАКТНЫЙ КЛАСС

//abstract class Shape {
//    public abstract double getVolume();
//}
//
//abstract class SolidOfRevolution extends Shape {
//    protected double radius;
//
//    public SolidOfRevolution(double radius) {
//        this.radius = radius;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
//}
//
//class Ball extends SolidOfRevolution { // конкретный класс
//
//    @Override
//    public double getVolume() {
//        return Math.PI * Math.pow(radius, 3) * 4 / 3;
//    }
//
//    public Ball(double radius) {
//        super(radius);
//    }
//}
//
//class Cylinder extends SolidOfRevolution { // конкретный класс
//    private double height;
//
//    public Cylinder(double radius, double height) {
//        super(radius);
//        this.height = height;
//    }
//
//    @Override
//    public double getVolume() {
//        return Math.PI * radius * radius * height;
//    }
//}
//
//class Pyramid extends Shape {
//    private double height;
//    private double s; // площадь основания
//
//    public Pyramid(double height, double s) {
//        this.height = height;
//        this.s = s;
//    }
//
//    @Override
//    public double getVolume() {
//        return height * s * 4 / 3;
//    }
//}
//
//
//class Box extends Shape {
//    private ArrayList<Shape> shapes = new ArrayList<>();
//    private double available;
//    private double volume;
//
//    public Box(double available) {
//        this.available = available;
//        this.volume = available;
//    }
//
//    public boolean add(Shape shape) {
//        if (available >= shape.getVolume()) {
//            shapes.add(shape);
//            available -= shape.getVolume();
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public double getVolume() {
//        return volume;
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Ball ball = new Ball(4.5);
//        Cylinder cylyinder = new Cylinder(2, 2);
//        Pyramid pyramid = new Pyramid(100, 100);
//
//        Box box = new Box(1000);
//
//        System.out.println(box.add(ball)); // ok
//        System.out.println(box.add(cylyinder)); // ok
//        System.out.println(box.add(pyramid)); // failed
//
//    }
//}