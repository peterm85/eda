package eda.videoclub.messaging.wrapper.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MongoDBSourceConnectorWrapperMessage {

  @JsonIgnore private Schema schema;

  private Object payload;
}
