package com.example.jsonStudy;


import com.google.gson.Gson;
public class Test2 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // 简单的数据类型转化为json
        String intStr = gson.toJson(1);
        String stringStr = gson.toJson("abcd");
        String longStr = gson.toJson(new Long(10));
        System.out.println(intStr);
        System.out.println(stringStr);
        System.out.println(longStr);
        // json 转化为简单数据类型
        int id1 = gson.fromJson("1", int.class);
        Integer id2 = gson.fromJson("2", Integer.class);
        Boolean boolean1 = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(boolean1);
        System.out.println(str);

        // java Array 转为 json
        String[] strings = {"abc", "def", "ghi"};
        int[][] intInt = {{1,2,3}, {4,5,6},{7,8,9}};
        String stringStrs = gson.toJson(strings);
        String intIntStr = gson.toJson(intInt);
        System.out.println(stringStrs);
        System.out.println(intIntStr);
        // json 转为 java array
        String[] strings2 = gson.fromJson(stringStrs, String[].class);
        int[][] intInt2 = gson.fromJson(intIntStr, int[][].class);
        for (int i = 0; i < strings2.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < intInt2.length; i++) {
            for (int j = 0; j < intInt2[i].length; j++) {
                System.out.print(intInt2[i][j] + " ");
            }
            System.out.println();
        }
    }
}