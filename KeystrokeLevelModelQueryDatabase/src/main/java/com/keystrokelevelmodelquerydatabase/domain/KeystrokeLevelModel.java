package com.keystrokelevelmodelquerydatabase.domain;

import java.util.List;

public record KeystrokeLevelModel(
  Integer index,
  List<Word> words,
  Image image,
  List<String> ignoreWords,
  CalculateMeta calculateMeta,
  CalculateCount calculateCount,
  User user,
  String date
) {}
