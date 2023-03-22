package projects.dex.collectman.repository.common.auditor;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {
    private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);

    @Override
    public Optional<String> getCurrentAuditor() {
        Optional<Authentication> authentication = Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication());

        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());
        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());
        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());
        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());
        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());
        logger.debug("##### IM HERE ::: {}", ( authentication.get().getPrincipal()).toString());

        return Optional.of("DEFUSER");
    }

}
