package com.keystrokelevelmodelquerydatabase;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.keystrokelevelmodelquerydatabase.wrapper.Response;

public class KeystrokeLevelModelQueryDatabaseApplication implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  private final APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent().withHeaders(Response.header());

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
    return responseEvent
      .withStatusCode(200)
      .withBody("Hello World!!");
  }
}
