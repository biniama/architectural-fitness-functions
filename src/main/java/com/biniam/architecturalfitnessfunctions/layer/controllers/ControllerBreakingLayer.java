package com.biniam.architecturalfitnessfunctions.layer.controllers;

import com.biniam.architecturalfitnessfunctions.layer.repositories.RepositoryA;
import com.biniam.architecturalfitnessfunctions.layer.services.ServiceB;

/**
 * @author Biniam Asnake
 */
public class ControllerBreakingLayer {

	private final RepositoryA repositoryA;

	public ControllerBreakingLayer(RepositoryA repositoryA) {
		this.repositoryA = repositoryA;
	}
}
