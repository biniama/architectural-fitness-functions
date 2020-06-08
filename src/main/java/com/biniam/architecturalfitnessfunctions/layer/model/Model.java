package com.biniam.architecturalfitnessfunctions.layer.model;


import com.biniam.architecturalfitnessfunctions.layer.util.Util;

/**
 * @author Biniam Asnake
 */
public class Model {

	String name;

	public String getName() {
		return Util.lower(name);
	}
}
