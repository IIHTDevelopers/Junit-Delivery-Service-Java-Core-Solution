package com.delivery.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.delivery.service.DeliveryService;

public class DeliveryTest {
	DeliveryService service = null;

	@Test
	public void testCalculateDeliveryTime_StandardShortDistance() {
		service = new DeliveryService(50, "standard");
		assertEquals(72, service.calculateDeliveryTime()); // Base time with no additional time due to short distance
	}

	@Test
	public void testCalculateDeliveryTime_ExpressShortDistance() {
		service = new DeliveryService(50, "express");
		assertEquals(24, service.calculateDeliveryTime()); // Base time with no additional time for express
	}

	@Test
	public void testCalculateDeliveryTime_StandardLongDistance() {
		service = new DeliveryService(350, "standard");
		assertEquals(88, service.calculateDeliveryTime()); // Base time plus additional time for distance
	}

	@Test
	public void testCalculateDeliveryTime_ExpressLongDistance() {
		service = new DeliveryService(350, "express");
		assertEquals(31, service.calculateDeliveryTime()); // Base time plus additional time for express distance
	}

	@Test
	public void testCalculateDeliveryTime_StandardVeryLongDistance() {
		service = new DeliveryService(950, "standard");
		assertEquals(116, service.calculateDeliveryTime()); // Testing with a very long distance
	}

	@Test
	public void testCalculateDeliveryTime_ExpressVeryLongDistance() {
		service = new DeliveryService(950, "express");
		assertEquals(43, service.calculateDeliveryTime()); // Express for very long distance
	}

	@Test
	public void testCalculateDeliveryTime_InvalidType() {
		service = new DeliveryService(100, "ultra");
		assertEquals(72, service.calculateDeliveryTime()); // Falls back to standard for invalid type
	}
}
