package com.delivery.service;

public class DeliveryService {
	private int distance;
	private String deliveryType;

	public DeliveryService(int distance, String deliveryType) {
		this.distance = distance;
		this.deliveryType = deliveryType;
	}

	public int calculateDeliveryTime() {
		int baseTime;
		if ("express".equalsIgnoreCase(deliveryType)) {
			baseTime = 24;
		} else {
			baseTime = 72;
		}
		int additionalTime = distance / 100 * (deliveryType.equalsIgnoreCase("express") ? 2 : 4);
		return baseTime + additionalTime;
	}
}
