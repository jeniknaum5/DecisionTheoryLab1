import com.sun.source.tree.ParenthesizedTree;

import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class Main {

    //ВАРИАНТ 20 - входные данные 
    public static int[][] inputs = {{67, 12, 92, 29, 2, 68, 31, 2, 74, 7, 18, 16, 83, 77, 87, 72, 73, 57, 62, 25},
            {33, 97, 96, 18, 41, 53, 26, 74, 80, 93, 85, 48, 5, 30, 29, 59, 98, 60, 62, 24},
            {19, 80, 41, 2, 10, 80, 26, 83, 89, 40, 8, 23, 38, 57, 93, 31, 10, 20, 5, 90}};

    //определяем множество оптимальных решений по Парето
    public static void ParetoMeth(ArrayList<Integer> arrayList) {
        ArrayList<Integer> q1 = new ArrayList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        ArrayList<Integer> OutputPareto = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            q1.add(arrayList.get(i) / 10); //добавляем первую цифру каждого эл-та в массив
            q2.add(arrayList.get(i) % 10); //добавляем вторую цифру каждого эл-та в массив
            OutputPareto.add(0);         //заполняем выходной массив нулями
        }
        for (Integer integer : q1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : q2) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : OutputPareto) {
            System.out.print(integer + " ");
        }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (OutputPareto.get(i) > 0)
                    break;
                if (OutputPareto.get(j) > 0)
                    continue;

                if (q1.get(i).equals(q1.get(j)) && q2.get(i).equals(q2.get(j)))
                    OutputPareto.set(j, 0);
                else if (q1.get(i) >= q1.get(j) && q2.get(i) >= q2.get(j))
                    OutputPareto.set(j, i + 1);
                else if (q1.get(i) <= q1.get(j) && q2.get(i) <= q2.get(j)) {
                    OutputPareto.set(i, j + 1);
                    break;
                }
            }
        }
        System.out.println();
        for (Integer integer : OutputPareto) {
            System.out.print(integer + " ");
        }
    }

    public static void SlaterMeth(int[] res) {

    }

    public static void main(String[] args) {
        //вывод входных данных
        System.out.println("|||Входные данные|||");
        for (int[] row : inputs) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        //создаем массив, в который будем помещат ряд
        ArrayList<Integer> RowOfInput = new ArrayList<>();

        //запускаем цикл в 3 итерации (каждая итерация на ряд входных данных)
        //for (int j = 0; j<3; j++){}
        //заполняем ряд значениями
        System.out.println("\n|||Ряд №1|||");
        for (int i = 0; i < 20; i++) {
            RowOfInput.add(i, inputs[0][i]);
            System.out.print(RowOfInput.get(i) + " ");
        }
        System.out.println();


        System.out.println("\n/////////////");

        ParetoMeth(RowOfInput);

    }
}
