package eda.videoclub.service.user.port.producer;

import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;

public interface EventProducer {

  void sendMessage(UserValidationCommand command);

  void sendErrorMessage(UserValidationCommand command, RejectionReasonVO reason);
}
