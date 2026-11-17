package pe.com.aseguramed.platform.u202421392.insurance.domain.services;

import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.commands.CreateHealthPolicyCommand;

/**
 * Command service that defines the operations to create a {{aggregate}}.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public interface HealthPolicyCommandService {
    /**
     * Creates a new {{aggregate}}.
     *
     * @param command the create command
     * @return the created {{aggregate}}
     */
    HealthPolicy handle(CreateHealthPolicyCommand command);
}
