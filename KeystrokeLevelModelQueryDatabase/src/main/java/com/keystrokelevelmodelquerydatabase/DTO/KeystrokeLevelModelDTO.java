package com.keystrokelevelmodelquerydatabase.DTO;

import com.keystrokelevelmodeldatabase.domain.KeystrokeLevelModel;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.util.List;


@DynamoDbBean
public class KeystrokeLevelModelDTO {

  private Integer index;
  public String userId;
  private String filename;
  private List<WordDTO> wordsDTO;
  private List<String> ignoreWordsDTO;
  private ImageDTO imageDTO;
  private CalculateMetaDTO calculateMetaDTO;
  private CalculateCountDTO calculateCountDTO;
  private String username;
  private String date;

  public KeystrokeLevelModelDTO(){}

  @DynamoDbAttribute(value="index")
  public Integer getIndex() {
    return index;
  }

  @DynamoDbPartitionKey
  public String getUserId() {
    return userId;
  }

  @DynamoDbSortKey
  public String getFilename() {
    return filename;
  }

  @DynamoDbAttribute(value="words")
  public List<WordDTO> getWordsDTO() {
    return wordsDTO;
  }

  @DynamoDbAttribute(value="ignoreWords")
  public List<String> getIgnoreWordsDTO() {
    return ignoreWordsDTO;
  }

  @DynamoDbAttribute(value="images")
  public ImageDTO getImageDTO() {
    return imageDTO;
  }

  @DynamoDbAttribute(value="calculateMeta")
  public CalculateMetaDTO getCalculateMetaDTO() {
    return calculateMetaDTO;
  }

  @DynamoDbAttribute(value="calculateCount")
  public CalculateCountDTO getCalculateCountDTO() {
    return calculateCountDTO;
  }

  @DynamoDbAttribute(value="username")
  public String getUsername() {
    return username;
  }

  @DynamoDbAttribute(value="date")
  public String getDate() {
    return date;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public void setWordsDTO(List<WordDTO> wordsDTO) {
    this.wordsDTO = wordsDTO;
  }

  public void setIgnoreWordsDTO(List<String> ignoreWordsDTO) {
    this.ignoreWordsDTO = ignoreWordsDTO;
  }

  public void setImageDTO(ImageDTO imageDTO) {
    this.imageDTO = imageDTO;
  }

  public void setCalculateMetaDTO(CalculateMetaDTO calculateMetaDTO) {
    this.calculateMetaDTO = calculateMetaDTO;
  }

  public void setCalculateCountDTO(CalculateCountDTO calculateCountDTO) {
    this.calculateCountDTO = calculateCountDTO;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
