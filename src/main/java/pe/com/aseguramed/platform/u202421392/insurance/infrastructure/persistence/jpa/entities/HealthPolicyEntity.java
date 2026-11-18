package pe.com.aseguramed.platform.u202421392.insurance.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PartyId;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PolicyIdentifier;
import pe.com.aseguramed.platform.u202421392.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.com.aseguramed.platform.u202421392.shared.domain.model.valueobjects.PremiumSummary;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Persistence entity that stores a {{aggregate}} in the database.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
@Entity
@Table(name = "health_policies")
public class HealthPolicyEntity extends AuditableAbstractAggregateRoot<HealthPolicyEntity> {
    @Column(nullable = false, unique = true)
    private UUID policyIdentifier;

    @Column(nullable = false)
    private UUID employerId;

    @Column(nullable = true)
    private String  coverageDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PolicyStatus status;

    @Column(nullable = false)
    private BigDecimal basePremium;

    @Column(nullable = false)
    private BigDecimal eventDeductible;

    @Column(nullable = false)
    private BigDecimal pharmacyCoverageLimit;

    @Column(nullable = false)
    private Integer beneficiaryCount;

    public HealthPolicyEntity() {}

    /**
     * Converts a {{aggregate}} aggregate into a persistence entity.
     *
     * @param healthPolicy the {{aggregate}} aggregate
     * @return the persistence entity
     */
    public static HealthPolicyEntity fromDomain(HealthPolicy healthPolicy) {
        var entity = new HealthPolicyEntity();
        entity.policyIdentifier = healthPolicy.getPolicyIdentifier().value();
        entity.employerId = healthPolicy.getEmployerId().value();
        entity.coverageDetails = healthPolicy.getCoverageDetails();
        entity.status = healthPolicy.getStatus();
        entity.basePremium = healthPolicy.getPremiumSummary().basePremium();
        entity.eventDeductible = healthPolicy.getPremiumSummary().eventDeductible();;
        entity.pharmacyCoverageLimit = healthPolicy.getPremiumSummary().pharmacyCoverageLimit();
        entity.beneficiaryCount = healthPolicy.getBeneficiaryCount();
        return entity;
    }

    /**
     * Converts this persistence entity into a {{aggregate}} aggregate.
     *
     * @return the {{aggregate}} aggregate
     */
    public HealthPolicy toDomain() {
        return new HealthPolicy(
                getId(),
                new PolicyIdentifier(policyIdentifier),
                new PartyId(employerId),
                coverageDetails,
                status,
                new PremiumSummary(basePremium, eventDeductible, pharmacyCoverageLimit),
                beneficiaryCount
        );
    }
}
