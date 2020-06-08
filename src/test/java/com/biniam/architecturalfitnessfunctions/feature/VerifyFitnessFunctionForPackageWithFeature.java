package com.biniam.architecturalfitnessfunctions.feature;

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
public class VerifyFitnessFunctionForPackageWithFeature {

	// Analyze all sources in src/main/java
	private final AnalyzerConfig config = AnalyzerConfig.maven().main("com.biniam.architecturalfitnessfunctions.feature");

	@Test
	public void noCyclicDependencyAllowed() {
		// Check that we have no CyclicDependencies
		assertThat(new DependencyAnalyzer(config).analyze(), hasNoCycles());
	}

	@Test
	public void verifyPackageByFeature() {

		// Defines the dependency rules for Packaging By Feature
		// NOTE: the classname should match the package name
		class ComBiniamArchitecturalfitnessfunctionsFeature extends DependencyRuler {
			// Rules for feature child packages
			// NOTE: they should match the name of the sub packages
			DependencyRule a, b, model, util;

			// Rules for org.proj.dep, org.proj.model, org.proj.util
			// DependencyRule dep, model, util;


			@Override
			public void defineRules() {
				// Our Application classes depends on all subpackages because it constructs all of them
				// `com.biniam.architecturalfitnessfunctions.feature` MAY USE all subpackages
				// feature a and b should not share anything
				base().mayUse(base().allSubOf());

				// com.biniam.architecturalfitnessfunctions.feature.a and all subpackages thereof MUST USE com.biniam.architecturalfitnessfunctions.feature
				// .model
				a.andAllSub().mustUse(model);

				// com.biniam.architecturalfitnessfunctions.feature.model MAY USE .util but not the main package
				model.mayUse(util).mustNotUse(base());
			}
		}

		// All dependencies are forbidden, except the ones defined in ComBiniamArchitecturalfitnessfunctionsFeature
		// java, org, net packages may be used freely
		DependencyRules rules = DependencyRules.denyAll()
				.withRelativeRules(new ComBiniamArchitecturalfitnessfunctionsFeature())
				.withExternals("java.*", "org.*", "net.*");

		DependencyResult result = new DependencyAnalyzer(config).rules(rules).analyze();
		assertThat(result, matchesRulesExactly());
	}
}
