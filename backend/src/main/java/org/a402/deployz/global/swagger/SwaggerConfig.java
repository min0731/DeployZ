package org.a402.deployz.global.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
			.group("v1-definition")
			.pathsToMatch("/**")
			.build();
	}

	@Bean
	public OpenAPI colorTheRockOpenAPI() {
		String jwtSchemeName = "jwtAuth";
		// API 요청헤더에 인증정보 포함
		SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
		// SecuritySchemes 등록
		Components components = new Components()
			.addSecuritySchemes(jwtSchemeName, new SecurityScheme()
				.name(jwtSchemeName)
				.type(SecurityScheme.Type.HTTP) // HTTP 방식
				.scheme("bearer")
				.bearerFormat("JWT")); // 토큰 형식을 지정하는 임의의 문자(Optional)

		return new OpenAPI().addServersItem(new Server().url("/"))
			.info(new Info().title("Deployz")
				.description("디플로이지 API 명세서입니다.")
				.version("v0.0.1"))
			.addSecurityItem(securityRequirement)
			.components(components);
	}

}