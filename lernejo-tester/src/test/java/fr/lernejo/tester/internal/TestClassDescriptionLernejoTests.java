package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestClassDescriptionLernejoTests {

    public static void main(String args[]){
        listTestMethods();
    }

    //@Test
    static void listTestMethods() {
        Class<SomeLernejoTests> testClass = SomeLernejoTests.class;
        TestClassDescription testClassDescription = new TestClassDescription(testClass);
        List<Method> methodeTrouver = testClassDescription.listTestMethods();
        System.out.println(methodeTrouver);
        //assertEquals(methodeTrouver.size(), 2);
    }
}
