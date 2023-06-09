package org.a402.deployz.domain.git.controller;

import java.util.Map;

import org.a402.deployz.domain.deploy.response.ItemDeployResponse;
import org.a402.deployz.domain.deploy.service.DeployService;
import org.a402.deployz.domain.git.request.GitWebHookRequest;
import org.a402.deployz.domain.git.service.GitService;
import org.a402.deployz.global.common.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/git")
public class GitController {
	private final GitService gitService;
	private final DeployService deployService;

	@PostMapping("/webhook")
	public BaseResponse<ItemDeployResponse> buildByWebHook(@RequestHeader(name = "X-Gitlab-Token") String secretToken,
		@RequestBody Map<String, Object> requestParams) {
		log.info("webhook start");
		final GitWebHookRequest gitWebHookRequest = gitService.detectWebHook(secretToken, requestParams);
		final ItemDeployResponse itemDeployResponse = deployService.itemDeploy(gitWebHookRequest);

		log.info("webhook Done");
		return new BaseResponse<>(itemDeployResponse);
	}
}
