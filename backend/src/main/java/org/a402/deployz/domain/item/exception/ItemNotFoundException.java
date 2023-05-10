package org.a402.deployz.domain.item.exception;

import org.a402.deployz.global.error.GlobalBaseException;
import org.a402.deployz.global.error.GlobalErrorCode;

public class ItemNotFoundException extends GlobalBaseException {
	public ItemNotFoundException() {
		super(GlobalErrorCode.ITEM_NOT_FOUND);
	}
}
