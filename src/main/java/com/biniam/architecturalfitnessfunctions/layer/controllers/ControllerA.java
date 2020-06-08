package com.biniam.architecturalfitnessfunctions.layer.controllers;

import com.biniam.architecturalfitnessfunctions.layer.services.ServiceA;

/**
 * @author Biniam Asnake
 */
public class ControllerA {

	private final ServiceA serviceA;

	public ControllerA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
}
