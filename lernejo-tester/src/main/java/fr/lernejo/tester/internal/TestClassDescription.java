package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    private Class<?> classTest;
    public TestClassDescription(Class<?> p_class){
        this.classTest = p_class;
    }
    public List<Method> listTestMethods(){
        Method[] declareMethods = this.classTest.getDeclaredMethods();
        List<Method> methodetest = new ArrayList<Method>();
        for (Method method : declareMethods){
            if(Modifier.isPublic(method.getModifiers()) && method.getAnnotation(TestMethod.class) != null){
                methodetest.add(method);
            }
        }
        return methodetest;
    }
}
