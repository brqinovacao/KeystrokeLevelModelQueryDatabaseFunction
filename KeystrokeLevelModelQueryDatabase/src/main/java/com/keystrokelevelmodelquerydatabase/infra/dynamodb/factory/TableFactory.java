package com.keystrokelevelmodelquerydatabase.infra.dynamodb.factory;

import com.keystrokelevelmodelquerydatabase.infra.dynamodb.DynamodbConnect;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

import java.net.URI;

public class TableFactory<T>  {

  public DynamoDbTable<T> connectTable(Class<T> entity) {

    var tableName = System.getenv("DATABASE_NAME");

    if(System.getenv("LAMBDA_ENVIRONMENT").equals("LOCAL")) {
      return new DynamodbConnect<T>()
        .createClient(URI.create(System.getenv("DYNAMODB_ENDPOINT")))
        .enhanced()
        .table(tableName, entity);
    }

    return new DynamodbConnect<T>()
      .createClient()
      .enhanced()
      .table(tableName, entity);
  }
}