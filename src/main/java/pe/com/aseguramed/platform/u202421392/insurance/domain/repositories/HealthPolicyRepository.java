package pe.com.aseguramed.platform.u202421392.insurance.domain.repositories;

import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PolicyIdentifier;

/**
 * Domain repository that defines the persistence operations of a {{aggregate}}.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public interface HealthPolicyRepository {
    /**
     * Saves a {{aggregate}}.
     *
     * @param healthPolicy the {{aggregate}} to save
     * @return the saved {{aggregate}} with its generated id
     */
    HealthPolicy save(HealthPolicy healthPolicy);
    /**
     * Checks if a {{aggregate}} with the given code already exists.
     *
     * @param policyIdentifier the code
     * @return true if it exists, false otherwise
     */
    boolean existsByPolicyIdentifier(PolicyIdentifier policyIdentifier);
}
