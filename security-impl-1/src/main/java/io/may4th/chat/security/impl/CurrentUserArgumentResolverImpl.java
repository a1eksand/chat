package io.may4th.chat.security.impl;

import io.may4th.chat.security.api.CurrentUser;
import io.may4th.chat.security.api.CurrentUserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserArgumentResolverImpl implements CurrentUserArgumentResolver {

    private final UserDetailsRequestHolder userDetailsRequestHolder;

    @Autowired
    public CurrentUserArgumentResolverImpl(UserDetailsRequestHolder userDetailsRequestHolder) {
        this.userDetailsRequestHolder = userDetailsRequestHolder;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        var userDetails = userDetailsRequestHolder.getUserDetails().orElse(null);
        return parameter.getParameterType().isInstance(userDetails) ?
            userDetailsRequestHolder.getUserDetails().orElse(null) :
            null;
    }
}
