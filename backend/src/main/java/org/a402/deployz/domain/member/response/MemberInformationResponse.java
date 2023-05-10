package org.a402.deployz.domain.member.response;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberInformationResponse {
	@NotNull
	@Schema(description = "이메일")
	private final String email;
	@NotNull
	@Schema(description = "프로필 이미지")
	private final String profileImage;

}
