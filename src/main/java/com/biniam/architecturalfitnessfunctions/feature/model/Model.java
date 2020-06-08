package com.biniam.architecturalfitnessfunctions.feature.model;

import com.biniam.architecturalfitnessfunctions.feature.util.Util;

/**
 * @author Biniam Asnake
 */
public class Model {

	String name;

	public String getName() {
		return Util.lower(name);
	}
}
