package com.bank.onboarding.commonslib.web;

import com.bank.onboarding.commonslib.web.dtos.ErrorResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;


@AllArgsConstructor
public class HeaderInterceptor implements HandlerInterceptor {

    private final String clientId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if(clientId.equals(request.getHeader("X-Onboarding-Client-Id"))){
            return true;
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .httpMethod(request.getMethod())
                .httpResponseStatus(response.getStatus())
                .errorMessage("O clientId não foi introduzido ou não é valido")
                .build();

        response.getWriter().print(new ObjectMapper().writeValueAsString(errorResponseDTO));
        return false;
    }
}
