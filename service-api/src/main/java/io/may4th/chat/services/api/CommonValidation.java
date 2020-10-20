package io.may4th.chat.services.api;

public interface CommonValidation {
    String WITHOUT_WHITESPACE = "^\\S*$";
    String TRIMMED_SINGLE_LINE = "^(\\S(.*\\S)?)?$";
    String TRIMMED_MULTI_LINE = "^(\\S(?s:.*\\S)?)?$";
}
