package com.biniam.architecturalfitnessfunctions.layer.repositories;

import com.biniam.architecturalfitnessfunctions.layer.services.ServiceA;

/**
 * @author Biniam Asnake
 */
public class RepositoryBreakingLayer {

	private final ServiceA serviceA;

	public RepositoryBreakingLayer(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
}
