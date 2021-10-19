package utils.email;

import java.io.IOException;
import java.util.function.Predicate;
import javax.mail.Message;
import javax.mail.MessagingException;
import lombok.SneakyThrows;

public interface MessageFilter extends Predicate<Message> {
  boolean shouldRetain(Message m) throws IOException, MessagingException;

  @SneakyThrows
  @Override
  default boolean test(Message message) {
    return shouldRetain(message);
  }
}
