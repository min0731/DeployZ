package org.a402.deployz.domain.member.exception;

import org.a402.deployz.global.error.GlobalBaseException;
import org.a402.deployz.global.error.GlobalErrorCode;

public class ServerKeyFileNotFoundException extends GlobalBaseException {
	public ServerKeyFileNotFoundException() {
		super(GlobalErrorCode.FILE_NOT_FOUND);
	}
}
