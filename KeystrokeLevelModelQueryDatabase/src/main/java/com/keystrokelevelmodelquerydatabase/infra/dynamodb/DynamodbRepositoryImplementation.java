package com.keystrokelevelmodelquerydatabase.infra.dynamodb;

import com.keystrokelevelmodelquerydatabase.services.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DynamodbRepositoryImplementation<T> implements Repository<T> {

  private final DynamoDbTable<T> connectTable ;

  public DynamodbRepositoryImplementation(DynamoDbTable<T> connectTable) {
    this.connectTable = connectTable;
  }

  @Override
  public List<T> findAll(UUID partitionValue) {
    QueryConditional keyEqual = QueryConditional.keyEqualTo(b -> b.partitionValue(partitionValue.toString()));

    QueryEnhancedRequest tableQuery = QueryEnhancedRequest.builder()
      .queryConditional(keyEqual)
      .build();

    PageIterable<T> pageResults = this.connectTable.query(tableQuery);
    return pageResults.stream().map(Page::items).findFirst().orElse(new ArrayList<>());
  }
}
