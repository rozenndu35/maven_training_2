package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {

    private String nomPackage;
    public TestClassDiscoverer(String p_nomPaquage){
        this.nomPackage= p_nomPaquage;
    }
    public List<TestClassDescription> listTestClasses(){
        Reflections reflections = new Reflections(this.nomPackage, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        List<TestClassDescription> listRendu = new ArrayList<TestClassDescription>();
        for ( Class<?> classe : allTypes) {
        	if( classe.getName().endsWith("LernejoTests")) {
        		boolean present = false;
        		Method[] declareMethods = classe.getDeclaredMethods();
                for (Method method : declareMethods){
                    if(method.getAnnotation(TestMethod.class) != null){
                        present = true;
                    }
                }
                if (present) {
                	listRendu.add(new TestClassDescription(classe));
                }
        	}
        }
        return listRendu;
    }
}
