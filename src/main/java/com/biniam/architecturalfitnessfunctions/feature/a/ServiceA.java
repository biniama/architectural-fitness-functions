package com.biniam.architecturalfitnessfunctions.feature.a;

import com.biniam.architecturalfitnessfunctions.feature.b.RepositoryB;
import com.biniam.architecturalfitnessfunctions.feature.b.ServiceB;
import com.biniam.architecturalfitnessfunctions.feature.model.Model;

/**
 * @author Biniam Asnake
 */
public class ServiceA {

	private final RepositoryA repositoryA;

	public ServiceA(RepositoryA repositoryA) {
		this.repositoryA = repositoryA;
	}

	public void useModel() {
		// Using model
		Model model = new Model();

		// Break test of // feature a and b should not share anything
		// ServiceB serviceB = new ServiceB(new RepositoryB());
	}

	public void cyclicDependency() {
		ServiceB serviceB = new ServiceB(new RepositoryB());
	}
}
