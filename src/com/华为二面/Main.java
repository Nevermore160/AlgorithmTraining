package com.华为二面;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int main(int[] a){
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        while (list.size() <= a.length - 1){
            for (int i = 0; i < a.length; i++) {
                if (list.contains(a[i])) continue;
                temp += 1;
                if(temp % 3 == 0) {
                    list.add(a[i]);
                    temp = 0;
                }
            }
        }
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(a[i])) num = a[i];
        }
        return num;
    }
}
