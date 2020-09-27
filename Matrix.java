import java.awt.event.MouseAdapter;

class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3, 3);
        Matrix b = new Matrix(3, 3);
        int[][] test1 = {{3, 2, 1}, {4, 3, 3}, {5, 3, 3}};
        int[][] test2 = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
        int[][] matprod1 = {{1, 2}, {2, 1}, {3, 2}};
        int[][] matprod2 = {{1, 3, 1}, {2, 1, 1}};
        //для удобства передаем номер матрицы
//        Matrix.Showmatrix(a.array,1);
//        Matrix.Showmatrix(b.array, 2);
        Matrix.Showmatrix(test1, 1);
        Matrix.Showmatrix(test2, 2);
        Matrix.Summ(test1, test2);
        Matrix.Sub(test1, test2);
        Matrix.Mult(test1, test2);
        Matrix.showProduct(Matrix.Product(matprod1, matprod2));
        Matrix.Degree(test1, 3);
    }
}

class Matrix {
    private int row;
    private int col;
    public int[][] array;

    public Matrix(int n, int m) {
        row = n;
        col = m;
        this.array = new int[row][col];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.array[i][j] = (int) (Math.random() * 2 + 3);
            }
        }

    }

    public static void Summ(int[][] a, int[][] b) {
        a = a;
        b = b;
        int[][] result = new int[a.length][b.length];
        System.out.println("\n" + "Результат вычетания матриц:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
                System.out.print(result[i][j] + "\t");
                if (j == a[0].length - 1) System.out.println();

            }
        }
    }

    public static void Sub(int[][] a, int[][] b){
        a = a;
        b = b;

        int[][] result = new int[a.length][b.length];
        System.out.println("\n" + "Результат сложения матриц:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
                System.out.print(result[i][j] + "\t");
                if (j == a[0].length - 1) System.out.println();

            }

        }
    }

    public static void Mult(int[][] a, int[][] b) {
        a = a;
        b = b;
        int[][] result = new int[a.length][b.length];
        int counter = 0;
        System.out.println("\n" + "Результат умножения матриц:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                counter += a[i][j] * b[i][j];
            }
            for (int j = 0; j < a[0].length; j++) {

                result[i][j] = counter;
                System.out.print(result[i][j] + "\t");
                if (j == a[0].length - 1) System.out.println();
            }
            counter = 0;
        }
    }

    public static int[][] Product(int[][] a, int[][] b) {
        a = a;
        b = b;
        int result_summ = 0;
        int[][] result = new int[a.length][b[0].length];
        int check = 0;
        for (int i = 0; i < a.length; i++) {
            for (int l = 0; l < b[0].length; l++) {
                for (int j = 0; j < b.length; j++) {
                    result_summ += a[i][j] * b[j][l];
                }
                result[i][l] = result_summ;
                result_summ = 0;
            }
        }
        return result;
    }

    public static void showProduct(int[][] result) {
        System.out.println("Резульат произведения матриц:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
                if (j == result[0].length - 1) System.out.println();
            }
        }
    }

    public static void Degree(int[][] a, int b) {
        System.out.print("Результат возведения матрицы в степень:\n");
        int[][] mtrx = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                mtrx[i][j] = a[i][j];
            }
        }
        a = a;
        b = b;
        int check = 1;
        while (check != b) {
            int[][] matrix = Matrix.Product(a, mtrx);

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    mtrx[i][j] = matrix[i][j];
                }
            }
            check += 1;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(mtrx[i][j] + "\t");
                if (j == a[0].length - 1) System.out.println();
            }
        }

    }


    public static void Showmatrix(int[][] matrix, int number) {
        matrix = matrix;
        number = number;
        System.out.println("Матрица №" + number);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
                if (j == matrix[0].length - 1) System.out.println();
            }
        }
    }
}