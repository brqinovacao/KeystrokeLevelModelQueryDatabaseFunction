package com.keystrokelevelmodelquerydatabase.DTO;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class WordDTO {

  private String index;
  private String id;
  private String text;
  private String width;
  private String height;
  private String left;
  private String top;
  private String confidence;

  public WordDTO(){}

  @DynamoDbAttribute(value = "index")
  public String getIndex() {
    return index;
  }

  @DynamoDbAttribute(value = "id")
  public String getId() {
    return id;
  }

  @DynamoDbAttribute(value = "text")
  public String getText() {
    return text;
  }

  @DynamoDbAttribute(value = "width")
  public String getWidth() {
    return width;
  }

  @DynamoDbAttribute(value = "height")
  public String getHeight() {
    return height;
  }

  @DynamoDbAttribute(value = "left")
  public String getLeft() {
    return left;
  }

  @DynamoDbAttribute(value = "top")
  public String getTop() {
    return top;
  }

  @DynamoDbAttribute(value = "confidence")
  public String getConfidence() {
    return confidence;
  }

  public void setIndex(String index) {
    this.index = index;
  }


  public void setId(String id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public void setLeft(String left) {
    this.left = left;
  }

  public void setTop(String top) {
    this.top = top;
  }

  public void setConfidence(String confidence) {
    this.confidence = confidence;
  }
}