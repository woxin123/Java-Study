package top.mcwebsite.map.test;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 18-8-11 下午3:29
 */
public class LiFangTi {

    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        int towers[] = new int[n];
        int minK[] = new int[k];
        int maxK[] = new int[k];

        for (int i = 0; i < n; i++) {
            towers[i] = sc.nextInt();
        }
        boolean flag = true;
        int min, max;
        int x;
        if (n == 1) {
            System.out.println(towers[0] + " 0");
            return;
        }
        for (x = 0; x < k; x++) {
            min = 0;
            max = 0;
            for (int i = 0; i < n; i++) {
                if (towers[min] > towers[i]) {
                    min = i;
                }
                if (towers[max] < towers[i]) {
                    max = i;
                }
            }
//            System.out.println(min + " " + max);
            if (towers[min] == towers[max]) {
                break;
            }
            if ((towers[max] - towers[min]) == 1) {
                if (flag) {
                    flag = false;
                } else {
                    x--;
                    break;
                }
            }
            towers[max]--;
            towers[min]++;
            minK[x] = min + 1;
            maxK[x] = max + 1;

        }
        min = 0;
        max = 0;
        for (int i = 0; i < n; i++) {
            if (towers[min] > towers[i]) {
                min = i;
            }
            if (towers[max] < towers[i]) {
                max = i;
            }
        }
        int s = towers[max] - towers[min];
        System.out.println(s + " " + x);
        for (int j = 0; j < x; j++) {
            System.out.println(maxK[j] + " " + minK[j]);
        }
    }
}