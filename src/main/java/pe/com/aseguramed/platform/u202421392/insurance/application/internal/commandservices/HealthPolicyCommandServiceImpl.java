package pe.com.aseguramed.platform.u202421392.insurance.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.commands.CreateHealthPolicyCommand;
import pe.com.aseguramed.platform.u202421392.insurance.domain.repositories.HealthPolicyRepository;
import pe.com.aseguramed.platform.u202421392.insurance.domain.services.HealthPolicyCommandService;

/**
 * Command service implementation that creates a {{aggregate}} and rejects duplicated codes.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
@Service
public class HealthPolicyCommandServiceImpl implements HealthPolicyCommandService {
    private final HealthPolicyRepository healthPolicyRepository;

    public HealthPolicyCommandServiceImpl(HealthPolicyRepository healthPolicyRepository) {
        this.healthPolicyRepository = healthPolicyRepository;
    }

    /**
     * Creates a new {{aggregate}} if its code is not registered yet.
     *
     * @param command the create command
     * @return the created {{aggregate}}
     */
    @Override
    public HealthPolicy handle(CreateHealthPolicyCommand command) {
        var healthPolicy = new HealthPolicy(command);
        if(healthPolicyRepository.existsByPolicyIdentifier(healthPolicy.getPolicyIdentifier())) {
            throw new IllegalArgumentException();
        }
        return healthPolicyRepository.save(healthPolicy);
    }

}
