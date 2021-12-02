package fr.lernejo.tester.internal;

import java.util.List;

import fr.lernejo.tester.api.TestMethod;

public class TestClassDiscovererLernejoTests {

	@TestMethod
    public void listTestClasses() {
    	TestClassDiscoverer testClassDiscover = new TestClassDiscoverer("fr.lernejo.tester");
    	List<TestClassDescription> classeTrouver = testClassDiscover.listTestClasses();
        System.out.println(classeTrouver);
    }
}
