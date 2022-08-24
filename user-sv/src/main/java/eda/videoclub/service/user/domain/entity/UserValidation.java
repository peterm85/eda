package eda.videoclub.service.user.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserValidation {

  private String id;

  private String imdbId;

  private String userId;
}
