package com.keystrokelevelmodelquerydatabase.useCase;

import com.keystrokelevelmodelquerydatabase.DTO.KeystrokeLevelModelDTO;
import com.keystrokelevelmodelquerydatabase.domain.KeystrokeLevelModel;
import com.keystrokelevelmodelquerydatabase.factory.FromKeystrokeLevelModelTODomain;
import com.keystrokelevelmodelquerydatabase.services.Repository;

import java.util.List;
import java.util.UUID;

public class KeystrokeLevelModelQuery {

  private final Repository<KeystrokeLevelModelDTO> repository;

  public KeystrokeLevelModelQuery(Repository<KeystrokeLevelModelDTO> repository) {
    this.repository = repository;
  }

  public List<KeystrokeLevelModel> findAllKeystrokeLevelModels(UUID key) {
    var keystrokeLevelModels = this.repository.findAll(key);
    return FromKeystrokeLevelModelTODomain.convert(keystrokeLevelModels);
  }
}
