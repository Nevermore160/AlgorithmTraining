package com.华为;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> query(int Low, int High){
        int temp = 0;
        for (int i = 1; i < 9; i++) {
            if (Low / pow(i) == Low) temp = i;
        }
        int num = Low / pow(temp - 1);
        List<Integer> list = new ArrayList<>();
        int num1 = Num(num, temp), num2 = 0;
        for (int i = temp - 1; i >= 0; i--) {
            num2 += pow(i);
        }
        if (num1 < Low && num1 % 10 != 9) num1 += num2;
        while (num1 < High){
            if (num1 % 10 == 9){
                temp += 1;
                num2 += pow(temp - 1);
                num1 = Num(1, temp);
                continue;
            }
            list.add(num1);
            num1 += num2;
        }
        return list;
    }

    public int Num(int num1, int num2){
        int num = 0;
        for (int i = num2 - 1; i >= 0; i--) {
            num += (num1 + num2 - 1 -i) * pow(i);
        }
        return num;
    }

    public int pow(int n){
        if (n == 0) return 1;
        int num = 1;
        for (int i = 0; i < n; i++) {
            num *= 10;
        }
        return num;
    }
}
