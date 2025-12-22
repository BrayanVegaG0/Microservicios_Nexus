package com.nexus.ms_transacciones.client;

import com.nexus.ms_transacciones.dto.SwitchTransaccionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class SwitchClient {

    private final RestTemplate restTemplate;

    @Value("${app.switch.url}")
    private String urlSwitch;

    public void enviar(SwitchTransaccionDTO request) {
        String finalUrl = urlSwitch + "/api/transacciones"; // Ajuste según endpoint del switch
        log.info("Enviando transacción al Switch: {} -> {}", finalUrl, request);
        // Si falla, el RestTemplate lanza excepción y activa el Catch del SAGA
        restTemplate.postForEntity(finalUrl, request, Void.class);
    }
}