package com.keystrokelevelmodelquerydatabase.domain;

import java.math.BigDecimal;

public record CalculateMeta(
  BigDecimal taps,
  BigDecimal indicate,
  BigDecimal drag,
  BigDecimal flick,
  BigDecimal zoom,
  BigDecimal metalAct,
  BigDecimal distraction,
  BigDecimal totalTime
) {
}
