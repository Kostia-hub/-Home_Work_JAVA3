package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init() {
        solution = new Solution();
    }

    @Test
    public void TestBuildAfterFour(){
        int[] arrInput = {1, 4, 5, 6, 3, 6, 4, 6, 7, 3};
        int[] arrResult = {6, 7, 3};
        Assertions.assertArrayEquals(arrResult, solution.buildAfterFour(arrInput));
    }

    @Test
    public void TestBuildAfterFour_2(){
        final int[] arrInput = {1, 2, 5, 6, 3, 6, 2, 6, 7, 3};
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            public void execute() throws Throwable {
                solution.buildAfterFour(arrInput);
            }
        });
    }

    @Test
    public void TestCheckNumbers(){
        int[] arrInput = {1, 4, 1, 4, 4, 4, 4, 1, 1, 1};
        Assertions.assertTrue(solution.checkNumbers(arrInput));
    }

    @Test
    public void TestCheckNumbers_2(){
        int[] arrInput = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(solution.checkNumbers(arrInput));
    }

    @Test
    public void TestCheckNumbers_3(){
        final int[] arrInput = {1, 4, 1, 4, 5, 4, 4, 1, 1, 1};
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            public void execute() throws Throwable {
                solution.checkNumbers(arrInput);
            }
        });
    }
}
