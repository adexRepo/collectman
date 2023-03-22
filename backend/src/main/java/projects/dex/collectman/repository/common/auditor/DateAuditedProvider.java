package projects.dex.collectman.repository.common.auditor;

import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

import org.springframework.data.auditing.DateTimeProvider;

import jakarta.annotation.Nonnull;

public class DateAuditedProvider implements DateTimeProvider {

    @Override @Nonnull
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(ZonedDateTime.now());
    }
}
