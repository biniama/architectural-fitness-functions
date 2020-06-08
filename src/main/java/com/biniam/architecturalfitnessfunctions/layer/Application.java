package com.biniam.architecturalfitnessfunctions.layer;

import com.biniam.architecturalfitnessfunctions.layer.controllers.ControllerA;
import com.biniam.architecturalfitnessfunctions.layer.repositories.RepositoryA;
import com.biniam.architecturalfitnessfunctions.layer.services.ServiceA;
import com.biniam.architecturalfitnessfunctions.layer.controllers.ControllerB;
import com.biniam.architecturalfitnessfunctions.layer.repositories.RepositoryB;
import com.biniam.architecturalfitnessfunctions.layer.services.ServiceB;

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
