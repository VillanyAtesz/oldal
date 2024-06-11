package com.github.villany_atesz.oldal.filter;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.munkamenet.MunkamenetRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
class BejelentkezesEllenorzo extends OncePerRequestFilter {
    private static final String MUNKAMENET_AZONOSITO_SUTI = "munkamenet_azonosito";

    private final MunkamenetRepository munkamenetRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!beVanJelentkezve(request)) {
            if (request.getRequestURI().startsWith("/web")) {
                response.sendRedirect("/");
            } else {
                response.setStatus(401);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write("Jelentkezz be!");
                writer.flush();
                writer.close();
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean beVanJelentkezve(HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
            .filter(cookie -> MUNKAMENET_AZONOSITO_SUTI.equals(cookie.getName()))
            .findAny()
            .map(Cookie::getValue)
            .flatMap(munkamenetRepository::findById)
            .filter(munkamenet -> LocalDateTime.now().isBefore(LocalDateTime.parse(munkamenet.getLejarat())))
            .isPresent();
    }
}
