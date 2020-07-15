package com.github.tantalor93;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class SomeResponse {

	@JsonProperty
	private String msg;

	public SomeResponse() {
	}

	public SomeResponse(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
