package uk.jinhy.umcstudy.validation.resolver;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import uk.jinhy.umcstudy.validation.annotation.PageNumber;

@Slf4j
@Component
public class PageNumberResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info(parameter.hasParameterAnnotation(PageNumber.class) + "");
        return parameter.hasParameterAnnotation(PageNumber.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Long originalValue = Long.parseLong(webRequest.getParameterValues(parameter.getParameterName())[0]);
        log.info(originalValue + "");
        return originalValue - 1;
    }
}
