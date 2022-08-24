package eda.videoclub.messaging.wrapper.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Schema {
  private String type;
  private boolean optional;
}
