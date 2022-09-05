package eda.videoclub.service.user.port.producer;

import org.springframework.kafka.support.SendResult;

import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;

public interface EventProducer {

  SendResult<String, ?> sendMessage(UserValidationCommand command);

  SendResult<String, ?> sendErrorMessage(UserValidationCommand command, RejectionReasonVO reason);
}
