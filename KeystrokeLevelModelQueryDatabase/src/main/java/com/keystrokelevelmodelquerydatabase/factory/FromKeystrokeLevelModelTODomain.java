package com.keystrokelevelmodelquerydatabase.factory;

import com.keystrokelevelmodelquerydatabase.DTO.*;
import com.keystrokelevelmodelquerydatabase.domain.*;
import java.util.List;

public record FromKeystrokeLevelModelTODomain() {

  public static List<KeystrokeLevelModel> convert(List<KeystrokeLevelModelDTO> keystrokeLevelModelDTO) {
    return keystrokeLevelModelDTO.stream().map(klm ->
      new KeystrokeLevelModel(
        klm.getIndex(),
        toWord(klm.getWordsDTO()),
        toImage(klm.getImageDTO(), klm.getFilename()),
        klm.getIgnoreWordsDTO().stream().map(String::new).toList(),
        toCalculateMeta(klm.getCalculateMetaDTO()),
        toCalculateCount(klm.getCalculateCountDTO()),
        new User(klm.getUserId(), klm.getUsername()),
        klm.getDate()
      )).toList();
  }

  private static List<Word> toWord(List<WordDTO> wordDTO) {
    return wordDTO.stream().map(word ->
      new Word(word.getIndex(),
        word.getId(),
        word.getText(),
        word.getWidth(),
        word.getHeight(),
        word.getLeft(),
        word.getTop(),
        word.getConfidence())
    ).toList();
  }

  private static Image toImage(ImageDTO image, String filename) {
    return new Image(image.getTotalWords(), image.getWidth(), image.getHeight(), image.getUrl(), filename);
  }

  private static CalculateCount toCalculateCount(CalculateCountDTO calculateCountDTO) {
    return new CalculateCount(
      calculateCountDTO.getTaps(),
      calculateCountDTO.getIndicate(),
      calculateCountDTO.getDrag(),
      calculateCountDTO.getFlick(),
      calculateCountDTO.getZoom(),
      calculateCountDTO.getMentalAct(),
      calculateCountDTO.getDistraction()
    );
  }

  private static CalculateMeta toCalculateMeta(CalculateMetaDTO calculateMetaDTO) {
    return new CalculateMeta(
      calculateMetaDTO.getTaps(),
      calculateMetaDTO.getIndicate(),
      calculateMetaDTO.getDrag(),
      calculateMetaDTO.getFlick(),
      calculateMetaDTO.getZoom(),
      calculateMetaDTO.getMetalAct(),
      calculateMetaDTO.getDistraction(),
      calculateMetaDTO.getTotalTime()
    );
  }
}
