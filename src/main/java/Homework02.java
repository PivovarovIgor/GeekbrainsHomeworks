import java.util.Arrays;

public class Homework02 {
    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
        //0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        task1();

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
        //значениями 0 3 6 9 12 15 18 21;
        task2();

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        //умножить на 2;
        task3();

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
        //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        task4();

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
        //помощи интернета);
        task5FindMinMax();

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
        //2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println("task 5 chekBalance");

        int[] exArr = {3, 4, -4, 6, 5};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{1, 2, 1, 2, 50};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{10, 2, 1, 2, 5};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{1, 2, 10, 2, 5};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{10};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{10, 10};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{10, 5};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        exArr = new int[]{10, 5, 5};
        System.out.print(Arrays.toString(exArr) + " - ");
        System.out.println(chekBalance3(exArr));

        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
        //положительным, или отрицательным), при этом метод должен сместить все элементы
        //массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
        //пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->
        //[ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг
        //можете выбирать сами.
        exArr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("task 6 shiftArray");
        System.out.println(Arrays.toString(exArr));
        exArr = shiftArray(exArr, 3);
        System.out.println("сдвиг 3 " + Arrays.toString(exArr));
        exArr = shiftArray(exArr, -2);
        System.out.println("сдвиг -2 " + Arrays.toString(exArr));
        exArr = shiftArray(exArr, -12);
        System.out.println("сдвиг -12 " + Arrays.toString(exArr));
        exArr = shiftArray(exArr, -4);
        System.out.println("сдвиг -4 " + Arrays.toString(exArr));

    }

    public static void task1(){

        System.out.println("task 1");

        int[] a = {0,1,1,1,0,0,1,0,1};

        System.out.println(Arrays.toString(a));

        for(int i = 0; i < a.length; i++)
            a[i] = (a[i] == 0) ? 1 : 0;

        System.out.println(Arrays.toString(a));

    }

    public static void task2(){

        System.out.println("task 2");

        int[] a = new int[8];

        System.out.println(Arrays.toString(a));

        for(int i = 0; i < a.length; i++)
            a[i] = i * 3;

        System.out.println(Arrays.toString(a));

    }

    public static void task3(){

        System.out.println("task 3");

        int[] a = {1,5,3,2,11,4,5,2,4,8,9,1};

        System.out.println(Arrays.toString(a));

        for(int i = 0; i < a.length; i++)
            if (a[i] < 6)
                a[i] *= 2;

        System.out.println(Arrays.toString(a));

    }

    public static void task4(){

        System.out.println("task 4");

        int[][] a = new int[7][7];

        print2DArray(a);

        for(int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[i][a.length - i - 1] = 1;
        }

        print2DArray(a);

    }

    public static void print2DArray(int[][] arr){

        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println("");

    }

    public static void task5FindMinMax(){

        System.out.println("task 5");

        int[] a = {15,5,3,2,-11,4,-5,2,4,8,9,1,6,5};

        System.out.println(Arrays.toString(a));

        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (min > a[i])
                min = a[i];
            if (max < a[i])
                max = a[i];
        }

        System.out.println("Max:" + max + " min:" + min);

    }

    public static boolean chekBalance(int[] arr){

        for (int i = 1; i < arr.length - 1; i++)  {

            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 0; j < arr.length; j++)
                if (j < i)
                    sumLeft += arr[j];
                else
                    sumRight += arr[j];

            if (sumLeft == sumRight)
                return true;
        }

        return false;
    }

    public static boolean chekBalance2(int[]  arr){

        if (arr.length < 2){
            return false;
        } else if (arr.length == 2){
            return (arr[0] == arr[1]);
        }

        int sumLeft = 0;
        int sumRight = 0;
        int i = -1;
        int step = 1;

        do{

            i += step;

            if (step == 1){
                sumLeft += arr[i];
                if (i == arr.length - 1){
                    step = -1;
                }
            }
            if (step == -1){
                sumLeft -= arr[i];
                sumRight += arr[i];
                if (sumLeft == sumRight){
                    return true;
                }
            }

        } while (i != 1 || step != -1);

        return false;
    }

    public static boolean chekBalance3(int[]  arr){

        if (arr.length < 2){
            return false;
        } else if (arr.length == 2){
            return (arr[0] == arr[1]);
        }

        double sum = 0;
        int step = 1;

        for (int i = 0; i > 0 || step != -1; i += step){
            if (step == 1 && i == arr.length){
                step = -1;
                sum /= 2;
                continue;
            }
            sum += arr[i] * step;
            if (step == -1 && sum == 0){
                return true;
            }
        }

        return false;
    }

    public static int[] shiftArray(int[] arr, int shift){

        if(arr.length == 0)
            return arr;

        int buf = 0;
        int nextInd = 0;
        for(int i = 0; i < arr.length; i++) {
            nextInd += shift;
            nextInd %= arr.length; //корректировка на длину массива
            if (nextInd < 0)
                nextInd = arr.length + nextInd; //корректировка  отрицательного индекса
            if (i == 0) {
                buf = arr[nextInd];
                arr[nextInd] = arr[i];
            } else {
                int buf2 = arr[nextInd];
                arr[nextInd] = buf;
                buf = buf2;
            }
        }

        return arr;
    }

}
