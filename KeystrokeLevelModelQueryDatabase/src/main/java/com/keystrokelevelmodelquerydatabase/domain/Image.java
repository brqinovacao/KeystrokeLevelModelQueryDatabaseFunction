package com.keystrokelevelmodelquerydatabase.domain;

public record Image(
  String totalWords,
  Float width,
  Float height,
  String url,
  String filename
) {}
