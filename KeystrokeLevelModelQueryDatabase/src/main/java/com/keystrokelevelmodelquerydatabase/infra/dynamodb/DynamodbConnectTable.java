package com.keystrokelevelmodelquerydatabase.infra.dynamodb;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

class DynamodbConnectTable<T> {

  public DynamoDbTable<T> connect(Class<T> entity, DynamoDbEnhancedClient client, String tableName) {
    return client.table(tableName, TableSchema.fromBean(entity));
  }
}
