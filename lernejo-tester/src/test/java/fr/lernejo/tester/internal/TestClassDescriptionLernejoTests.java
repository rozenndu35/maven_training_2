package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.List;


public class TestClassDescriptionLernejoTests {

    @TestMethod
    public void listTestMethods() {
        Class<SomeLernejoTests> testClass = SomeLernejoTests.class;
        TestClassDescription testClassDescription = new TestClassDescription(testClass);
        List<Method> methodeTrouver = testClassDescription.listTestMethods();
        System.out.println(methodeTrouver);
    }
    
}
