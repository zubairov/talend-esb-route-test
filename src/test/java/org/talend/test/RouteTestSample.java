package org.talend.test;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import esbdemos.simpleroute_0_1.SimpleRoute;

public class RouteTestSample extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    private RouteBuilder builder;
    
    @Test
    public void testSendMatchingMessage() throws Exception {
        String expectedBody = "bar";

        resultEndpoint.expectedBodiesReceived(expectedBody);
        template.sendBody(expectedBody);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testSendNotMatchingMessage() throws Exception {
        resultEndpoint.expectedMessageCount(0);

        template.sendBody("foo");

        resultEndpoint.assertIsSatisfied();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
    	SimpleRoute route  = new SimpleRoute();
    	// Setup the test aliases
		Map<String, String> uriProperties = route.getUriMap();
		uriProperties.put("start", "direct:start");
		uriProperties.put("end", "mock:result");
		route.loadCustomUriMap(uriProperties);
		// Build the route
    	builder = route.Route(false);
    	return builder.getContext();
    }
    
    @Override
    protected RouteBuilder createRouteBuilder() {
    	return builder;
    }
}