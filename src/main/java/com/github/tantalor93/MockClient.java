package com.github.tantalor93;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@RegisterRestClient
public interface MockClient {

	@POST
	@Path("/mock")
	Uni<SomeResponse> getMock(String body);
}
