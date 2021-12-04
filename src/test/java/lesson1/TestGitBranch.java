package lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGitBranch {

    @Test
        // wrong method for test
    void firstMethod() {
        Assertions.assertTrue(false);
    }


    @Test
    void secondMethod() {
        Assertions.assertTrue(true);
    }


}
