package com.junit.test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mockitoprime.prime;
import mockitoprime.primecontroller;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	primecontroller pc;
	@Before
	public void setup() {
		prime pc1 = mock(prime.class);
		when(pc1.isPrime(1)).thenReturn(false);
		when(pc1.isPrime(2)).thenReturn(true);
		pc = new primecontroller();
		pc.setObj(pc1);
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, pc.Prime(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, pc.Prime(2));
	}
	
}
