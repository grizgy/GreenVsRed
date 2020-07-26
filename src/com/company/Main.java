package com.company;


public class Main {


    public static int[][] getSumWeight(double[][] arr) {

        int a = arr.length;
        int b = arr[a-1].length;

        int sum[][] = new int[a][b];

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                int result = 0;

                if(j > 0)
                    result += arr[i][j-1];
                if(j < arr[i].length - 1)
                    result += arr[i][j+1];
                if(i > 0)
                    result += arr[i-1][j];

                if(i > 0 && j > 0)
                    result += arr[i-1][j-1];
                if(i > 0 && j < arr[i].length - 1)
                    result += arr[i-1][j+1];

                if(j > 0 && i < arr.length -1)
                    result += arr[i+1][j-1];
                if(j < arr[i].length - 1 && i < arr.length -1)
                    result += arr[i+1][j+1];
                if(i < arr.length -1)
                    result += arr[i+1][j];
                sum[i][j] = result;
                System.out.print(result);
            }
            System.out.println();
        }

        return sum;
    }


    public static void main(String[] args) {

        double[][] baseMap = {{2, 10, 7},
                                {4, 5, 8},
                                {5, 6, 9}};
        getSumWeight(baseMap);



    }
}
