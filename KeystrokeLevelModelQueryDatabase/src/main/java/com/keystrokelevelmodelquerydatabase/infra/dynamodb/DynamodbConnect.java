package com.keystrokelevelmodelquerydatabase.infra.dynamodb;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class DynamodbConnect<T> {

  private DynamodbConnectTable<T> table;

  private DynamoDbClient dynamodbClient;

  private DynamoDbEnhancedClient enhancedClient;

  public DynamodbConnect<T> createClient(URI endpoint) {
    //URI.create("http://dynamodb-local:8000")
      var client = DynamoDbClient.builder()
        .endpointOverride(endpoint)
        .region(Region.US_EAST_1)
        .build();

      this.setDynamodbClient(client);

      return this;
  }

  public DynamodbConnect<T> createClient() {
    var client = DynamoDbClient.builder()
      .region(Region.US_EAST_1)
      .build();

    this.setDynamodbClient(client);

    return this;
  }

  public DynamodbConnect<T> enhanced() {
    var enhanceClient = DynamoDbEnhancedClient.builder()
      .dynamoDbClient(this.dynamodbClient)
      .build();

    setEnhancedClient(enhanceClient);

    return this;
  }

  public DynamoDbTable<T> table(String tableName, Class<T> entity) {
    DynamodbConnectTable<T> table = new DynamodbConnectTable<>();
    return table.connect(entity, this.enhancedClient, tableName);
  }

  public DynamodbConnect<T> setDynamodbClient(DynamoDbClient dynamodbClient) {
    this.dynamodbClient = dynamodbClient;
    return this;
  }

  public void setEnhancedClient(DynamoDbEnhancedClient enhancedClient) {
    this.enhancedClient = enhancedClient;
  }

  private void setTable(DynamodbConnectTable<T> table) {
    this.table = table;
  }

  public DynamoDbClient getDynamodbClient() {
    return dynamodbClient;
  }
}

