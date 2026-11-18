package pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.entities.HealthPolicyEntity;

import java.util.UUID;

/**
 * JPA repository that stores and queries the persistence entities of a {{aggregate}}.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public interface HealthPolicyPersistenceRepository extends JpaRepository<HealthPolicyEntity, Long> {
    /**
     * Checks if a {{aggregate}} with the given code is stored.
     *
     * @param policyIdentifier the code
     * @return true if it exists, false otherwise
     */
    boolean existsByPolicyIdentifier(UUID policyIdentifier);
}
