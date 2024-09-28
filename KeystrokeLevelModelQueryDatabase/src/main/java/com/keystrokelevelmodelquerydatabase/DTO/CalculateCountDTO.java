package com.keystrokelevelmodelquerydatabase.DTO;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;

@DynamoDbBean
public class CalculateCountDTO {
  private BigDecimal taps;
  private BigDecimal indicate;
  private BigDecimal drag;
  private BigDecimal flick;
  private BigDecimal zoom;
  private BigDecimal mentalAct;
  private BigDecimal distraction;

  public CalculateCountDTO() {}


  @DynamoDbAttribute(value = "taps")
  public BigDecimal getTaps() {
    return taps;
  }

  @DynamoDbAttribute(value = "indicate")
  public BigDecimal getIndicate() {
    return indicate;
  }

  @DynamoDbAttribute(value = "drag")
  public BigDecimal getDrag() {
    return drag;
  }

  @DynamoDbAttribute(value = "flick")
  public BigDecimal getFlick() {
    return flick;
  }

  @DynamoDbAttribute(value = "zoom")
  public BigDecimal getZoom() {
    return zoom;
  }

  @DynamoDbAttribute(value = "mentalAct")
  public BigDecimal getMentalAct() {
    return mentalAct;
  }

  @DynamoDbAttribute(value = "distraction")
  public BigDecimal getDistraction() {
    return distraction;
  }

  public void setTaps(BigDecimal taps) {
    this.taps = taps;
  }

  public void setIndicate(BigDecimal indicate) {
    this.indicate = indicate;
  }

  public void setDrag(BigDecimal drag) {
    this.drag = drag;
  }

  public void setFlick(BigDecimal flick) {
    this.flick = flick;
  }

  public void setZoom(BigDecimal zoom) {
    this.zoom = zoom;
  }

  public void setMentalAct(BigDecimal mentalAct) {
    this.mentalAct = mentalAct;
  }

  public void setDistraction(BigDecimal distraction) {
    this.distraction = distraction;
  }
}
