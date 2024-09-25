package com.keystrokelevelmodelquerydatabase.DTO;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class ImageDTO {

  private String totalWords;
  private Float width;
  private Float height;
  private String url;

  public ImageDTO() {}

  @DynamoDbAttribute(value = "totalWords")
  public String getTotalWords() {
    return totalWords;
  }

  @DynamoDbAttribute(value = "width")
  public Float getWidth() {
    return width;
  }

  @DynamoDbAttribute(value = "hgeight")
  public Float getHeight() {
    return height;
  }

  @DynamoDbAttribute(value = "url")
  public String getUrl() {
    return url;
  }

  public void setTotalWords(String totalWords) {
    this.totalWords = totalWords;
  }

  public void setWidth(Float width) {
    this.width = width;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
