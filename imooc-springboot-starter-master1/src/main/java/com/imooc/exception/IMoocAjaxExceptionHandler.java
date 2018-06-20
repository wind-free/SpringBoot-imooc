package com.imooc.exception;

import javax.servlet.http.HttpServletRequest;

import com.imooc.pojo.IMoocJSONResult;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public IMoocJSONResult defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return IMoocJSONResult.errorException(e.getMessage());
	}
}
