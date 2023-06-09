package org.a402.deployz.domain.deploy.util.docker;

import static org.a402.deployz.domain.project.entity.enums.FrameworkType.*;

import org.a402.deployz.domain.item.entity.Item;

public class DockerCommandGenerator {

	public static String build(final Item item, final String repositoryPath) {
		StringBuilder sb = new StringBuilder();
		sb.append("docker build -t ")
			.append(item.getName().toLowerCase())
			.append(":latest ")
			.append(repositoryPath);
		return sb.toString();
	}

	public static String run(final Item item) {
		StringBuilder sb = new StringBuilder();
		sb.append("docker run --name ")
			.append(item.getName().toLowerCase())
			.append(" -d --rm -p ")
			.append(item.getPortNumber());
		if (item.getFrameworkType().equals(SPRINGBOOT.getName())) {
			sb.append(":8080 ");
		} else if (item.getFrameworkType().equals(REACT.getName())) {
			sb.append(":3000 ");
		}
		sb.append(item.getName().toLowerCase()).append(":latest");
		return sb.toString();
	}

	public static String stop(final String containerName) {
		StringBuilder sb = new StringBuilder();
		sb.append("docker stop ")
			.append(containerName);
		return sb.toString();
	}

	public static String rmi(final String containerName) {
		StringBuilder sb = new StringBuilder();
		sb.append("docker rmi ")
			.append(containerName)
			.append(":latest");
		return sb.toString();
	}
}
