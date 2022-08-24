package eda.videoclub.messaging.wrapper.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MongoDBSourceConnectorWrapperKey {

  @JsonIgnore private Schema schema;

  private String payload;
}
