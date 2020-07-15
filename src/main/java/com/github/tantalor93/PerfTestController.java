package com.github.tantalor93;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;

@Path("/")
public class PerfTestController {

    @Inject
    @RestClient
    private MockClient mockClient;

    @GET
    @Path("/ping")
    public String ping() {
        return "OK";
    }

    @POST
    @Path("/perf-test")
    @Produces("application/json")
    public Uni<String> perfTest(String body) {
        return mockClient.getMock(body)
                .map(SomeResponse::getMsg);
    }
}