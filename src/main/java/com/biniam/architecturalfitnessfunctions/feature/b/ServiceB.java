package com.biniam.architecturalfitnessfunctions.feature.b;

import com.biniam.architecturalfitnessfunctions.feature.a.RepositoryA;
import com.biniam.architecturalfitnessfunctions.feature.a.ServiceA;

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
