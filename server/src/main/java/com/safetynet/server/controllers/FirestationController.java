package com.safetynet.server.controllers;

import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FirestationController {

	@Autowired
	protected HttpServletRequest request;


	public FirestationController() {
	}

//	protected LogMetaData initLogMetadata
}
