package org.a402.deployz.domain.project.entity.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FrameworkType {
	SPRINGBOOT("SpringBoot"),
	REACT("React");

	private final String name;

	FrameworkType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static List<String> getFrameworkNames() {
		return Arrays.stream(FrameworkType.values())
			.map(FrameworkType::getName)
			.collect(Collectors.toList());
	}
}