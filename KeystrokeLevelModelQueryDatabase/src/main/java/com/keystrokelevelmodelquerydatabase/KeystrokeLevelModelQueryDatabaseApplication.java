package com.keystrokelevelmodelquerydatabase;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keystrokelevelmodelquerydatabase.DTO.KeystrokeLevelModelDTO;
import com.keystrokelevelmodelquerydatabase.infra.dynamodb.DynamodbRepositoryImplementation;
import com.keystrokelevelmodelquerydatabase.infra.dynamodb.factory.TableFactory;
import com.keystrokelevelmodelquerydatabase.useCase.KeystrokeLevelModelQuery;
import com.keystrokelevelmodelquerydatabase.wrapper.Response;
import com.sun.jdi.InternalException;

import java.util.UUID;

import java.util.logging.Logger;

public class KeystrokeLevelModelQueryDatabaseApplication implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  private final APIGatewayProxyResponseEvent responseEvent =
    new APIGatewayProxyResponseEvent()
      .withHeaders(Response.header());

  private final DynamodbRepositoryImplementation<KeystrokeLevelModelDTO> dynamoDbRepository =
    new DynamodbRepositoryImplementation<>(new TableFactory<KeystrokeLevelModelDTO>().connectTable(KeystrokeLevelModelDTO.class));

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

    var keystrokeLevelModelQuery = new KeystrokeLevelModelQuery(dynamoDbRepository);
    var result = keystrokeLevelModelQuery.findAllKeystrokeLevelModels(UUID.fromString(input.getPathParameters().get("userId")));

    try {
      return responseEvent
        .withStatusCode(200)
        .withBody(objectMapper.writeValueAsString(result));
    } catch (Exception ex) {
      throw new InternalException(ex.getMessage());
    }

  }
}
