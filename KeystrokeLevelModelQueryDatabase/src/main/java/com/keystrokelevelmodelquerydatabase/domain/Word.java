package com.keystrokelevelmodelquerydatabase.domain;

public record Word(
  String index,
  String id,
  String text,
  String width,
  String height,
  String left,
  String top,
  String confidence
) {
}
