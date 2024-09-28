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

  private final Logger logger = Logger.getAnonymousLogger();

  private final APIGatewayProxyResponseEvent responseEvent =
    new APIGatewayProxyResponseEvent()
      .withHeaders(Response.header());

  private final DynamodbRepositoryImplementation<KeystrokeLevelModelDTO> dynamoDbRepository =
    new DynamodbRepositoryImplementation<>(new TableFactory<KeystrokeLevelModelDTO>().connectTable(KeystrokeLevelModelDTO.class));

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

    logger.info("Iniciando consulta no banco");

    //var keystrokeLevelModelQuery = new KeystrokeLevelModelQuery(dynamoDbRepository);
    //var item = keystrokeLevelModelQuery.findAllKeystrokeLevelModels(UUID.fromString("0167ac40-da6e-4dd2-8507-033324a021dc"));

    try {
      logger.info(objectMapper.writeValueAsString(input));
      return responseEvent
        .withStatusCode(200)
        .withBody(objectMapper.writeValueAsString("SUCESSO"));
    } catch (Exception ex) {
      throw new InternalException(ex.getMessage());
    }

  }
}
