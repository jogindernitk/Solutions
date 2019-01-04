package arrayQuestions;

import java.util.BitSet;

public class ArrayQuestions {
    public static void main(String[] args) {
        System.out.println("Testing...");
        ArrayQuestions aq = new ArrayQuestions();
        int [] array1 = new int [] {1,3,5,6};
        aq.findMissing(array1,6);
    }

    private void findMissing(int [] arr , int count) {
        BitSet bs = new BitSet(count);
        for (int num : arr) {
            bs.set(num);
        }
        System.out.printf("There are %d missing number in the array " , count-bs.cardinality());
        int missingNumberIndex =bs.nextClearBit(0);
        int missingNumber = missingNumberIndex;
        System.out.println(missingNumberIndex);
        while (missingNumberIndex <= count) {
            System.out.printf("Missing index : %d", missingNumber);
            missingNumberIndex = bs.nextClearBit(missingNumber+1);
            missingNumber = missingNumberIndex;
        }
    }
}
