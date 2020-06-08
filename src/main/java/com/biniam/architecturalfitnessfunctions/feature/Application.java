package com.biniam.architecturalfitnessfunctions.feature;

import com.biniam.architecturalfitnessfunctions.feature.a.ControllerA;
import com.biniam.architecturalfitnessfunctions.feature.a.RepositoryA;
import com.biniam.architecturalfitnessfunctions.feature.a.ServiceA;
import com.biniam.architecturalfitnessfunctions.feature.b.ControllerB;
import com.biniam.architecturalfitnessfunctions.feature.b.RepositoryB;
import com.biniam.architecturalfitnessfunctions.feature.b.ServiceB;

/**
 * @author Biniam Asnake
 */
public class Application {

	public static void main(String[] args) {
		RepositoryA repositoryA = new RepositoryA();
		ServiceA serviceA = new ServiceA(repositoryA);
		ControllerA controllerA = new ControllerA(serviceA);

		RepositoryB repositoryB = new RepositoryB();
		ServiceB serviceB = new ServiceB(repositoryB);
		ControllerB controllerB = new ControllerB(serviceB);
	}
}
