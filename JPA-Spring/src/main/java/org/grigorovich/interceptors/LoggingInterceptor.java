package org.grigorovich.interceptors;

import lombok.SneakyThrows;
import org.grigorovich.aop.ControllersExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(ControllersExceptionHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        logUrl(req);
        logHeaders(req);
        logBody(req);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception {
        ContentCachingResponseWrapper respWrapper = (ContentCachingResponseWrapper) resp;
        String body = new String(respWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.debug("Response Body: \n {}", body);
    }

    @SneakyThrows
    private void logBody(HttpServletRequest req) {
        RealCachingRequestWrapper reqWrapper = (RealCachingRequestWrapper) req;
        String body = new String(reqWrapper.getContentAsByteArray(), req.getCharacterEncoding());
        log.debug("Request Body: \n {}", body);
    }

    private void logHeaders(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            log.debug("[{}]: {}", name, req.getHeader(name));
        }
    }

    private void logUrl(HttpServletRequest req) {
        log.info("{} {}", req.getMethod(), ServletUriComponentsBuilder.fromRequest(req).toUriString());
    }
}
