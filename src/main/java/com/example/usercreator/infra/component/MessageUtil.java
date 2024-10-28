package com.example.usercreator.infra.component;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Component
public class MessageUtil {

    private static MessageSource messageSource;

    public MessageUtil(MessageSource messageSource) {
        MessageUtil.messageSource = messageSource;
    }

    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }


}
