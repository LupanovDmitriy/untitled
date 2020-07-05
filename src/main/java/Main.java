import java.util.Arrays;
/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 Метод должен вернуть новый массив, который получен путем вытаскивания
 из исходного массива элементов, идущих после последней четверки.
 Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
 */

public class Main {

/*    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(partArr(arr, 4)));
        int[] arr1 = new int[]{1, 1, 1, 1, 4, 1, 1, 1, 1};

        System.out.println(checkArr(arr1));
    }
*/
    public static int[] partArr(int[] arr, int separator) {
        int possition = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == separator) {
                possition = i + 1;
            }
        }
        if (possition == 0) {
            throw new RuntimeException("Массив не содержит разделителя " + separator);
        }
        int[] retArr = new int[arr.length - possition];
        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = arr[i + possition];
        }
        return retArr;
    }

    public static boolean checkArr(int[] arr) {
        boolean contains1 = false;
        boolean contains4 = false;
        boolean containsOther = false;
        final int DIG1 = 1;
        final int DIG4 = 4;

        for (int i = 0; i <arr.length; i++) {
            if (arr[i] == DIG1) {
                contains1 = true;
            } else if (arr[i] == DIG4){
                contains4 = true;
            } else{
                containsOther=true;
            }
        }
        return (contains1 & contains4 & !containsOther);
    }
}
