package com.bidule;

import fr.lernejo.tester.api.TestMethod;

public class FactTest {
	
	private final Fact fact = new Fact();
	
	@TestMethod
	public void fact() {
		//cas d'erreur <0
		try {
			fact.fact(-1);
			throw new IllegalStateException();
		}catch(IllegalArgumentException e) {
			
		}
		//cas limite
		if(fact.fact(0) != 1) {
			throw new IllegalStateException();
		}
		//cas normal
		if(fact.fact(2) != 2) {
			throw new IllegalStateException();
		}
		
	}
}
