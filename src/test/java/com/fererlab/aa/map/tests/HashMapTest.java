package com.fererlab.aa.map.tests;

import com.fererlab.aa.map.HashMap;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * can
 */
public class HashMapTest {

	@Test
	public void testPutGet() throws Exception {
		HashMap<String, Integer> userAges = new HashMap<>();

		String john = "John";
		String jane = "Jane";
		String mike = "Mike";
		String kim = "Kim";

		userAges.put(john, 20);
		Integer age = userAges.get(john);
		Assert.assertEquals(age, new Integer(20));

		userAges.put(jane, 25);
		age = userAges.get(jane);
		Assert.assertEquals(age, new Integer(25));

		userAges.put(mike, 30);
		age = userAges.get(mike);
		Assert.assertEquals(age, new Integer(30));

		userAges.put(kim, 35);
		age = userAges.get(kim);
		Assert.assertEquals(age, new Integer(35));

	}

	@Test
	public void testPutSameKeys() throws Exception {
		HashMap<String, Integer> userAges = new HashMap<>();

		String john1 = "John";
		String john2 = "John";
		String john3 = "John";
		String john4 = "John";

		userAges.put(john1, 1);
		userAges.put(john2, 2);
		userAges.put(john3, 3);
		userAges.put(john4, 4);
	}

	@Test
	public void testPutSameValues() throws Exception {
		HashMap<String, Integer> userAges = new HashMap<>();

		String john = "John";
		String jane = "Jane";
		String mike = "Mike";
		String kim = "Kim";

		userAges.put(john, 1);
		userAges.put(jane, 1);
		userAges.put(mike, 1);
		userAges.put(kim, 1);
	}

	@Test
	public void testPutSameKeyValues() throws Exception {
		HashMap<String, Integer> userAges = new HashMap<>();
		String john1 = "John";
		userAges.put(john1, 1);
		userAges.put(john1, 1);
		userAges.put(john1, 1);
		userAges.put(john1, 1);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testPutNullKey() throws Exception {
		exception.expect(IllegalArgumentException.class);

		HashMap<String, Integer> map = new HashMap<>();
		map.put(null, 1);
	}

	@Test
	public void testPutNullValue() throws Exception {
		exception.expect(IllegalArgumentException.class);

		HashMap<String, Integer> map = new HashMap<>();
		map.put("key", null);
	}

}