package org.a402.deployz.global.security.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import com.nimbusds.oauth2.sdk.util.StringUtils;

@Component
public class HttpCookieOAuthAuthorizationRequestRepository
	implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
	public static final String OAUTH_2_AUTH_REQUEST = "oauth2_auth_request";
	public static final String REDIRECT_URI = "redirect_uri";
	private static final int cookieExpiredSeconds = 180;

	@Override
	public OAuth2AuthorizationRequest loadAuthorizationRequest(final HttpServletRequest request) {
		return CookieUtils.getCookie(request, OAUTH_2_AUTH_REQUEST)
			.map(cookie -> CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class))
			.orElse(null);
	}

	@Override
	public void saveAuthorizationRequest(final OAuth2AuthorizationRequest authorizationRequest,
		final HttpServletRequest request,
		final HttpServletResponse response) {
		if (authorizationRequest == null) {
			CookieUtils.deleteCookie(request, response, OAUTH_2_AUTH_REQUEST);
			CookieUtils.deleteCookie(request, response, REDIRECT_URI);
			return;
		}

		CookieUtils.addCookie(response, OAUTH_2_AUTH_REQUEST, CookieUtils.serialize(authorizationRequest),
			cookieExpiredSeconds);
		final String redirectURIAfterLogin = request.getParameter(REDIRECT_URI);
		if (StringUtils.isNotBlank(redirectURIAfterLogin)) {
			CookieUtils.addCookie(response, REDIRECT_URI, redirectURIAfterLogin, cookieExpiredSeconds);
		}

	}

	@Override
	public OAuth2AuthorizationRequest removeAuthorizationRequest(final HttpServletRequest request) {
		return this.loadAuthorizationRequest(request);
	}

	public void removeAuthorizationRequestCookies(final HttpServletRequest request,
		final HttpServletResponse response) {
		CookieUtils.deleteCookie(request, response, OAUTH_2_AUTH_REQUEST);
		CookieUtils.deleteCookie(request, response, REDIRECT_URI);
	}
}
