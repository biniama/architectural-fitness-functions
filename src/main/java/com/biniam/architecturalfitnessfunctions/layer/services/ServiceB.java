package com.biniam.architecturalfitnessfunctions.layer.services;

import com.biniam.architecturalfitnessfunctions.layer.repositories.RepositoryA;
import com.biniam.architecturalfitnessfunctions.layer.repositories.RepositoryB;

/**
 * @author Biniam Asnake
 */
public class ServiceB {

	private final RepositoryB repositoryB;

	public ServiceB(RepositoryB repositoryB) {
		this.repositoryB = repositoryB;
	}

	public void cyclicDependency() {
		ServiceA serviceA = new ServiceA(new RepositoryA());
	}
}
