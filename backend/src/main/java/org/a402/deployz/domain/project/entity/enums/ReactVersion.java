package org.a402.deployz.domain.project.entity.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ReactVersion {

	NODE14("node:14"),
	NODE16("node:16"),
	NODE17("node:17"),
	NODE18("node:18"),
	NODE19("node:19"),
	NODE20("node:20");
	private final String name;

	ReactVersion(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static List<String> getReactVersion() {
		return Arrays.stream(ReactVersion.values())
			.map(ReactVersion::getName)
			.collect(Collectors.toList());
	}
}
