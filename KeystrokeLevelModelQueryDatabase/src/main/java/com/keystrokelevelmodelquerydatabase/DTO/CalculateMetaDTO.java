package com.keystrokelevelmodelquerydatabase.DTO;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.math.BigDecimal;

@DynamoDbBean
public class CalculateMetaDTO {
  
  private BigDecimal taps;
  private BigDecimal indicate;
  private BigDecimal drag;
  private BigDecimal flick;
  private BigDecimal zoom;
  private BigDecimal metalAct;
  private BigDecimal distraction;
  private BigDecimal totalTime;

  public CalculateMetaDTO() {}

  public BigDecimal getTaps() {
    return taps;
  }

  public BigDecimal getIndicate() {
    return indicate;
  }

  public BigDecimal getDrag() {
    return drag;
  }

  public BigDecimal getFlick() {
    return flick;
  }

  public BigDecimal getZoom() {
    return zoom;
  }

  public BigDecimal getMetalAct() {
    return metalAct;
  }

  public BigDecimal getDistraction() {
    return distraction;
  }

  public BigDecimal getTotalTime() {
    return totalTime;
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

  public void setMetalAct(BigDecimal metalAct) {
    this.metalAct = metalAct;
  }

  public void setDistraction(BigDecimal distraction) {
    this.distraction = distraction;
  }

  public void setTotalTime(BigDecimal totalTime) {
    this.totalTime = totalTime;
  }
}
