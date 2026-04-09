package com.devgwon.moneytransfersystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "offsetTimeProvider")
public class JpaConfig {

    @Bean
    public DateTimeProvider offsetTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now(ZoneOffset.of("+09:00")));
    }


}
