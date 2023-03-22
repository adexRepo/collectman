package projects.dex.collectman.config.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import projects.dex.collectman.repository.common.auditor.AuditorAwareImpl;
import projects.dex.collectman.repository.common.auditor.DateAuditedProvider;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateAuditedProvider")
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    @Bean
    public DateTimeProvider  dateAuditedProvider() {
        return new DateAuditedProvider();
    }
}
