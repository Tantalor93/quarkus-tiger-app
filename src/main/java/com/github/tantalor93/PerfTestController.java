package com.github.tantalor93;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.buffer.Buffer;
import io.vertx.mutiny.ext.web.client.WebClient;

@Path("/perf-test")
public class PerfTestController {

    private WebClient client;

    @Inject
    public PerfTestController(Vertx vertx) {
        client = WebClient
                .create(vertx, new WebClientOptions().setDefaultHost("mock-server").setDefaultPort(8081));
    }

    @POST
    @Produces("application/json")
    public Uni<String> perfTest(String body) {
        return client.post("/mock").sendBuffer(Buffer.buffer(body))
                .map(e -> e.bodyAsJson(SomeResponse.class))
                .map(e -> e.getMsg());
    }
}