package ua.vitaliy.kiev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilateralTriangle {

    public static void buildEquilateralTriangle(int triangleDimension) {

        for (int i = 0; i < triangleDimension; i++) {
            for (int j = 0; j < 2 * triangleDimension; j++) {

                if ((i == 0 && j == triangleDimension) ||
                        (i < triangleDimension - 1 && (j == triangleDimension - i || j == triangleDimension + i)) ||
                        (i == triangleDimension - 1 && (j % 2 != 0))) {
                    System.out.print("*");
                } else System.out.print(" ");

                if (i == triangleDimension - 1 && j == triangleDimension + triangleDimension - 1) break;
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Insert odd equilateral triangle dimension (one-side length): ");
        int triangleDimension = Integer.parseInt(userInput.readLine());

        if (triangleDimension != 0) {
            EquilateralTriangle.buildEquilateralTriangle(triangleDimension);
            userInput.close();
        }
    }
}

