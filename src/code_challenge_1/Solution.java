/*
 * © 2021 tienhuynh.lttn
 * All rights reserved!
 * For more information, please contact via my email: tien.huynhlt.tn@gmail.com
 */
package code_challenge_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Huỳnh Lê Thủy Tiên <tien.huynhlt.tn@gmail.com>
 */

/*
Gray Code
An n-bit gray code sequence is a sequence of 2^n integers where:

Every integer is in the inclusive range [0, 2^n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.
 */
public class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            list.add(0);
            return list;
        }

        List<Integer> listN = grayCode(n - 1);
        int numToAdd = 1 << (n - 1); //2^(n-1): số lượng số cần add

        for (int i = listN.size() - 1; i >= 0; i--) {
            listN.add(numToAdd + listN.get(i));
        }

        return listN;
    }

    public void printAllList() {
        System.out.print("Output:");
        for (Integer integer : list) {
            System.out.print(" " + integer);
        }
        System.out.println("");
    }

    public int inputN() {
        int n = 0;
        boolean stillAdd = false;
        Scanner sc = new Scanner(System.in);

        System.out.print("Add n (1 <= n <= 16): ");
        do {
            try {
                sc = new Scanner(System.in);
                n = sc.nextInt();
                if (n < 1 || n > 16) {
                    throw new Exception();
                }
                stillAdd = false;
            } catch (Exception e) {
                System.out.print("Add another n: ");
                stillAdd = true;
            }
        } while (stillAdd);
        System.out.println("Input: " + n);

        return n;
    }

    public static void main(String[] args) {
        Solution list = new Solution();
        list.grayCode(list.inputN());
        list.printAllList();
    }
}
