package com.yiming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class GeneratorTest {

    @Test
    void test01() {
        String path = this.getClass().getResource("").getPath();
        System.out.println(path);
    }
}