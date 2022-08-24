package eda.videoclub.service.user.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private String id;

  private String name;

  private String address;

  private Integer age;
}
