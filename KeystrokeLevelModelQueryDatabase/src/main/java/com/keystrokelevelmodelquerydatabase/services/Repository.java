package com.keystrokelevelmodelquerydatabase.services;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {

  List<T> findAll(UUID partitionValue);
}
