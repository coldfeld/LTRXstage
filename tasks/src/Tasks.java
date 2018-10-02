import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Tasks {
    public static class CategoryA {
        public static void task1() {
            System.out.println("Задача А1. Принадлежность точки тругольнику.");
            TPoint[] mas = new TPoint[3];
            mas[0] = new TPoint(1, 1);
            mas[1] = new TPoint(0, -1);
            mas[2] = new TPoint(-1, -1);
            Triangle T = new Triangle(mas);
            TPoint tp = new TPoint(0, 0);
            if (T.isBelong(tp)) System.out.println("IN");
            else System.out.println("OUT");
        }

        public static int[][] createMatrix(int n, int m){
            Random rnd = new Random();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = rnd.nextInt(9);
                }
            }
            return arr;
        }

        public static int[][] createMatrix(int n, int m, int min, int max){
            Random rnd = new Random();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = rnd.nextInt(max) + min;
                }
            }
            return arr;
        }

        public static int[] createArray(int n){
            Random rnd = new Random();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rnd.nextInt(20) + 1;
            }
            return arr;
        }

        public static void printMatrix(int arr[][]){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.format("%4d",arr[i][j]);
                }
                System.out.println();
            }
        }

        public static void printArray(int arr[]){
            for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

        public static void task2() {
            System.out.println("Задача А2. Разница сумм диагоналей матрицы.");
            int[][] mtx = createMatrix(3,3);
            printMatrix(mtx);
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) d1 += mtx[i][j];
                    if (j == (mtx.length - 1 - i)) d2 += mtx[i][j];
                }
            }
            System.out.println("Для получившейся матрицы разница диагоналей равна " + Math.abs(d1 - d2));
        }

        public static void task3() {
            System.out.println("Задача А3. Вывод лестницы.");
            int n = 5;
            for (int i = 1; i <= n; i++){
                String str = "";
                for (int j = 0; j < i; j++) str += "#";
                System.out.format("%10s\n", str);
            }
        }

        public static void task4() {
            System.out.println("Задача А4. Поиск пар.");
            int k = 5, n = 0;
            int[] arr = new int[]{1,2,3,4,5,6};
            for (int i = 0; i < arr.length -1; i++){
                for (int j = i+1; j < arr.length; j++){
                    if ((arr[i] + arr[j])%k == 0) n++;
                }
            }
            System.out.print("Для массива { ");
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("} всего " + n + " пар, делящихся на " + k);
        }
        public static void task5() {
            System.out.println("Задача А5. Поиск окна матрицы.");
            int n = 11; int m = 10;
            int[][] arr = createMatrix(n,m);
            printMatrix(arr);
            int window[][] = createMatrix(2,2);

        }
    }
    public static class CategoryB {
        public static void task2() {
            System.out.println("Задача B2. Вывод массива змейкой. Вывод по спирали.\n");
            int n = 6;
            int[][] mtx = new int[n][n];
            int[] src = CategoryA.createArray(n * n);
            Arrays.sort(src);
            System.out.println("Исходный массив: ");
            CategoryA.printArray(src);
            //вывод по спирали
            int cnt = 0, i = 0, j = 0;
            System.out.println("Вывод по спирали:");
            while (cnt < src.length) {
                while ((j < n) && (mtx[i][j] == 0) && (cnt < src.length)) {
                    mtx[i][j++] = src[cnt++];
                }
                j--;
                i++;
                while ((i < n) && (mtx[i][j] == 0) && (cnt < src.length)) {
                    mtx[i++][j] = src[cnt++];
                }
                i--;
                j--;
                while ((j >= 0) && (mtx[i][j] == 0) && (cnt < src.length)) {
                    mtx[i][j--] = src[cnt++];
                }
                j++;
                i--;
                while ((i >= 0) && (mtx[i][j] == 0) && (cnt < src.length)) {
                    mtx[i--][j] = src[cnt++];
                }
                i++;
                j++;
            }
            CategoryA.printMatrix(mtx);
            //вывод змейкой
            mtx = new int[n][n];
            cnt = 1;
            mtx[0][0] = src[0];
            i = 0;
            j = 0;
            System.out.println("Вывод змейкой:");
            while (cnt < src.length - 1) {
                if(j + 1 < n){
                        mtx[i][++j] = src[cnt++];
                    }
                else if (i + 1 < n){
                    mtx[++i][j] = src[cnt++];
                }
                while((j > 0)&&(i < n - 1)){
                    mtx[++i][--j] = src[cnt++];
                }
                if(i + 1 < n){
                    mtx[++i][j] = src[cnt++];
                }
                else if (j + 1 < n) {
                    mtx[i][++j] = src[cnt++];
                }
                while ((i > 0)&&(j < n - 1)){
                    mtx[--i][++j] = src[cnt++];
                }
            }
            CategoryA.printMatrix(mtx);
        }

        public static void task1() {
            System.out.println("Задача B1. Проверка корректности скобочного выражения.\n");
            String input = "([ ] [{ }] ) [ ({}) ]({[]}) {[ ()] } ";
            Stack<Character> st = new Stack<Character>();
            boolean check = true;
            System.out.print("Для строки: ");
            for(char c : input.toCharArray()){
                switch (c){
                    case '(':
                        st.push('(');
                        break;
                    case '{':
                        st.push('{');
                        break;
                    case '[':
                        st.push('[');
                        break;
                    case ')':
                        if (st.empty()) check = false;
                        if (st.pop() != '(') check = false;
                        break;
                    case '}':
                        if (st.empty()) check = false;
                        if (st.pop() != '{') check = false;
                        break;
                    case ']':
                        if (st.empty()) check = false;
                        if (st.pop() != '[') check = false;
                        break;
                    default:
                        break;
                }
                System.out.print(c);
            }
            if (!st.empty()) check = false;
            if (check) System.out.print("\nSUCCESS");
                else System.out.print("\nFAIL");
        }

        public static void task3() {
            System.out.println("Задача А5. Поиск кратчайшего пути.");
            int n = 5, m = 7;
            System.out.println("Для матрицы ");
            int[][] src = CategoryA.createMatrix(n, m, 0, 99);
            CategoryA.printMatrix(src);
            int[][] weights = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0) {
                        if (j == 0) {
                            weights[i][j] = 0;
                            continue;
                        } else {
                            weights[i][j] = weights[i][j - 1] + src[i][j];
                        }
                    } else if (j == 0) {
                        weights[i][j] = weights[i - 1][j] + src[i][j];
                    } else
                        weights[i][j] = Math.min(weights[i - 1][j], weights[i][j - 1]) + src[i][j];
                }
            }
            System.out.println("\nТаблица весов: ");
            CategoryA.printMatrix(weights);
            System.out.println("\nМинимальный путь: ");
            int i = n - 1, j = m - 1;
            while ((i > 0) && (j > 0)) {
                if (weights[i - 1][j] <= weights[i][j - 1]) {
                    src[i - 1][j] = -1;
                    i--;
                } else if (weights[i][j - 1] <= weights[i - 1][j]) {
                    src[i][j - 1] = -1;
                    j--;
                }
            }
            if (i == 0) {
                while (j > 0) {
                    src[i][--j] = -1;
                }
            }
            if (j == 0) {
                while (i > 0) {
                    src[i--][j] = -1;
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    if ((i == 0) && (j == 0)) System.out.format("%3c", 'A');
                    else if (src[i][j] == -1) System.out.format("%3c", '*');
                    else if ((i == n - 1) && (j == m - 1)) System.out.format("%3c", 'B');
                    else System.out.format("%3d", src[i][j]);
                }
                System.out.println();
            }
        }
    }
}


