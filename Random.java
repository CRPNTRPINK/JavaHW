class show{
    public static void main(String[] args){
        int[] values = {1, 2, 3};
        int[] weight = {1, 2, 10};
        RandomFromArray random = new RandomFromArray(values, weight);
        System.out.print(random.getRandom());
    }
}


/*
    Решение основывается на геометрической идее:
    Будем считать, что веса — это длины некоторых отрезков.
    Тогда надо "уложить" все отрезки в один общий,
    генерировать случайное значение из этого общего отрезка,
    определять в какой из наших отрезков попало значение:
    |-|--|----------|
    0-1--3----------13
              ^ 
              
 */
class RandomFromArray {
    private int[] values; // значения
    private int[] weights; // веса
    private int[] ranges; // левые границы отрезков
    private int sum; // общая длина всех отрезков

    public RandomFromArray(int[] values, int[] weights) {
        this.values = values;
        this.weights = weights;
        ranges = new int[values.length];

        // Сумма длин всех отрезков
        sum = 0;
        for (int weight : weights) {
            sum += weight;
        }

        // Заполняем ranges, левыми границами
        int lastSum = 0;
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = lastSum;
            lastSum += weights[i];
        }
    }

    /*
        Массив ranges уже заполнен, так что остаётся
        сгенерировать значение в промежутке [0;sum],
        и найти отрезок, содержащий это значение:
     */
    public int getRandom() {
        int random = (int) (Math.random() * (sum - 1));

        int ourRangeIndex = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > random) {
                break;
            }
            ourRangeIndex = i;
        }

        return values[ourRangeIndex];
    }
}