package org.a402.deployz.domain.member.request;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterTokenRequest {
	@NotNull
	@Schema(description = "유저 개인 access token")
	private final String personalAccessToken;
}
