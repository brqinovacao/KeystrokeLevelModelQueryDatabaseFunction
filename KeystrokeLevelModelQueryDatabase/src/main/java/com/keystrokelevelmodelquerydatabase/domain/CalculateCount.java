package com.keystrokelevelmodelquerydatabase.domain;

import java.math.BigDecimal;

public record CalculateCount(
  BigDecimal taps,
  BigDecimal indicate,
  BigDecimal drag,
  BigDecimal flick,
  BigDecimal zoom,
  BigDecimal mentalAct,
  BigDecimal distraction
) {
}
