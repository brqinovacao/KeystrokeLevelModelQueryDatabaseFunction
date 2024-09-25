package com.keystrokelevelmodelquerydatabase;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keystrokelevelmodelquerydatabase.DTO.KeystrokeLevelModelDTO;
import com.keystrokelevelmodelquerydatabase.factory.FromKeystrokeLevelModelTODomain;
import com.keystrokelevelmodelquerydatabase.wrapper.Response;

import java.util.ArrayList;

public class KeystrokeLevelModelQueryDatabaseApplication implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  private final APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent().withHeaders(Response.header());

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

    try {
      var keystrokeLevelModel = FromKeystrokeLevelModelTODomain.convert(keystrokeLevelModelDTO);

      return responseEvent
        .withStatusCode(200)
        .withBody(keystrokeLevelModel);

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }



  }
}
