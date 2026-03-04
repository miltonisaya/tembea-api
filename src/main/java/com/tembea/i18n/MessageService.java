package com.tembea.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

  private final MessageSource messageSource;

  public String get(MessageKey key, Object... args) {
    return messageSource.getMessage(key.getKey(), args, LocaleContextHolder.getLocale());
  }

  public String get(MessageKey key) {
    return get(key, (Object[]) null);
  }
}
