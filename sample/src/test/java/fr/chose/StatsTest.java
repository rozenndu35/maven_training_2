package fr.chose;

import fr.lernejo.tester.api.TestMethod;

public class StatsTest {

	@TestMethod
	public void stat() {
		
		//cas limite
		if(Stats.of().max() != 0) {
			throw new IllegalStateException();
		}
		if(Stats.of().min() != 0) {
			throw new IllegalStateException();
		}
		if(Stats.of().sum() != 0) {
			throw new IllegalStateException();
		}
		if(Stats.of().avg() != 0) {
			throw new IllegalStateException();
		}
		//cas normal
		if(Stats.of(1,2,3,4,5,3).max() != 5) {
			throw new IllegalStateException();
		}
		if(Stats.of(1,2,3,4,5,3).min() != 1) {
			throw new IllegalStateException();
		}
		if(Stats.of(1,2,3,4,5,3).sum() != 18) {
			throw new IllegalStateException();
		}
		if(Stats.of(1,2,3,4,5,3).avg() != 3) {
			throw new IllegalStateException();
		}
		
	}
}
