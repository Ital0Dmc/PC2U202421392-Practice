package pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.adapters;

import org.springframework.stereotype.Repository;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PolicyIdentifier;
import pe.com.aseguramed.platform.u202421392.insurance.domain.repositories.HealthPolicyRepository;
import pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.entities.HealthPolicyEntity;
import pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.repositories.HealthPolicyPersistenceRepository;

/**
 * Repository adapter that implements the domain repository of a {{aggregate}} with JPA.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
@Repository
public class HealthPolicyRepositoryAdapter implements HealthPolicyRepository {
    private final HealthPolicyPersistenceRepository persistenceRepository;

    public HealthPolicyRepositoryAdapter(
            HealthPolicyPersistenceRepository persistenceRepository
    ) {
        this.persistenceRepository = persistenceRepository;
    }
    /**
     * Saves a {{aggregate}} by converting it into a persistence entity.
     *
     * @param healthPolicy the {{aggregate}} to save
     * @return the saved {{aggregate}} with its generated id
     */
    @Override
    public HealthPolicy save(HealthPolicy healthPolicy) {
        var entity = HealthPolicyEntity.fromDomain(healthPolicy);
        var savedEntity = persistenceRepository.save(entity);
        return savedEntity.toDomain();
    }

    /**
     * Checks if a {{aggregate}} with the given code already exists.
     *
     * @param policyIdentifier the code
     * @return true if it exists, false otherwise
     */
    @Override
    public boolean existsByPolicyIdentifier(PolicyIdentifier policyIdentifier) {
        return persistenceRepository.existsByPolicyIdentifier(policyIdentifier.value());
    }

}
