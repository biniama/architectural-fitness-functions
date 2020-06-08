package com.biniam.architecturalfitnessfunctions.layer;

import static guru.nidi.codeassert.junit.CodeAssertMatchers.hasNoCycles;
import static guru.nidi.codeassert.junit.CodeAssertMatchers.matchesRulesExactly;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import guru.nidi.codeassert.config.AnalyzerConfig;
import guru.nidi.codeassert.dependency.DependencyAnalyzer;
import guru.nidi.codeassert.dependency.DependencyResult;
import guru.nidi.codeassert.dependency.DependencyRule;
import guru.nidi.codeassert.dependency.DependencyRuler;
import guru.nidi.codeassert.dependency.DependencyRules;

/**
 * @author Biniam Asnake
 */
public class VerifyFitnessFunctionForPackageWithLayer {

	// Analyze all sources in src/main/java
	private final AnalyzerConfig config = AnalyzerConfig.maven().main("com.biniam.architecturalfitnessfunctions.layer");

	@Test
	public void noCyclicDependencyAllowed() {
		// Check that we have no CyclicDependencies
		assertThat(new DependencyAnalyzer(config).analyze(), hasNoCycles());
	}

	@Test
	public void verifyPackageByLayer() {

		// Defines the dependency rules for Packaging By Feature
		// NOTE: the classname should match the package name
		class ComBiniamArchitecturalfitnessfunctionsLayer extends DependencyRuler {
			// Rules for feature child packages
			// NOTE: they should match the name of the sub packages
			DependencyRule controllers, services, repositories, model, util;

			// Rules for org.proj.dep, org.proj.model, org.proj.util
			// DependencyRule dep, model, util;


			@Override
			public void defineRules() {
				// Our Application classes depends on all subpackages because it constructs all of them
				// `com.biniam.architecturalfitnessfunctions.feature` MAY USE all subpackages
				// feature a and b should not share anything
				base().mayUse(base().allSubOf());

				// Controllers may use Services
				controllers.mayUse(services);

				// Services may use Repositories
				services.mayUse(repositories);

				// com.biniam.architecturalfitnessfunctions.layer.services and all subpackages thereof MUST USE
				// com.biniam.architecturalfitnessfunctions.layer.model
				services.andAllSub().mustUse(model);

				// com.biniam.architecturalfitnessfunctions.layer.model MAY USE .util but not the main package
				model.mayUse(util).mustNotUse(base());
			}
		}

		// All dependencies are forbidden, except the ones defined in ComBiniamArchitecturalfitnessfunctionsLayer
		// java, org, net packages may be used freely
		DependencyRules rules = DependencyRules.denyAll()
				.withRelativeRules(new ComBiniamArchitecturalfitnessfunctionsLayer())
				.withExternals("java.*", "org.*", "net.*");

		DependencyResult result = new DependencyAnalyzer(config).rules(rules).analyze();
		assertThat(result, matchesRulesExactly());
	}
}
