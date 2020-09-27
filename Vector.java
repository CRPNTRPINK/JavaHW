class Main_vector{
    public static void main(String[] args){
        Vector first = new Vector(25, 30, 10);
        Vector second = new Vector(10, 15 , 20);
        System.out.print("Длина вектора - " + first.Length() + "\t");
        System.out.print("Длина вектора - " + second.Length() + "\t");
        double scalar = Vector.scalar_product(first, second);
        System.out.print("\n" + "Скалярное произведение - " + scalar);
        Vector.vector_product(first, second);
        Vector.angle(scalar, first.Length() * second.Length());
        Vector add = first.addition(second);//Сумма
        Vector subtract = first.subtract(second);//разность
        Vector[] vectors = Vector.generate(10); // статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N

    }
}

public class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double Length(){
        double result = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        return result;
    }

    public static double scalar_product(Vector a, Vector b){
        double result = a.x*b.x + a.y*b.y + a.z*b.z;
        return result;
    }

    public static void vector_product(Vector a, Vector b){
        double one = (a.y*b.z - a.z*b.y);
        double two = (a.z*b.x-a.x*b.z);
        double three = (a.x*b.y-a.y*b.x);
        System.out.print("\n" + "Векторное произведение - "+ one + " " + two + " " + three);
    }
    public static void angle(double a, double b){
        double result = a/b;
        System.out.print("\nУгол между векторами - " + result);
    }

    public Vector addition(Vector vector){
        return new Vector(
                x + vector.x,
                y + vector.y,
                z + vector.z
        );
    }

    public Vector subtract(Vector vector){
        return new Vector(
                x - vector.x,
                y - vector.y,
                z - vector.z
                );
    }

    public static Vector[] generate(int n){
        Vector[] vectors = new Vector[n];
        for(int i =0; i < n; i++){
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

}
