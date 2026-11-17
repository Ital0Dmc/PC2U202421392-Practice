package pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates;

import lombok.Getter;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.commands.CreateHealthPolicyCommand;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PartyId;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PolicyIdentifier;
import pe.com.aseguramed.platform.u202421392.shared.domain.model.valueobjects.PremiumSummary;


/**
 * Aggregate root that represents a {{aggregate}} and validates its business rules.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
@Getter
public class HealthPolicy {
    private Long id;
    private PolicyIdentifier policyIdentifier;
    private PartyId employerId;
    private String coverageDetails;
    private PolicyStatus status;
    private PremiumSummary premiumSummary;
    private Integer beneficiaryCount;

    /**
     * Creates a new {{aggregate}} from a create command.
     *
     * @param command the create command
     */
    public HealthPolicy(CreateHealthPolicyCommand command) {
        this(null,
                new PolicyIdentifier(command.policyIdentifier()),
                new PartyId(command.employerId()),
                command.coverageDetails(),
                command.status(),
                new PremiumSummary(command.basePremium(),
                        command.eventDeductible(), command.pharmacyCoverageLimit()),
                command.beneficiaryCount()
        );
    }
    /**
     * Creates a {{aggregate}} with all its data and applies its business rules.
     *
     * @param id              the generated id, null for a new {{aggregate}}
     * @param policyIdentifier  the code
     * @param employerId        the identifier from another bounded context
     * @param premiumSummary      the amounts
     * @param status the status
     * @param coverageDetails the text
     * @param beneficiaryCount the count
     */
    public HealthPolicy( Long id,
     PolicyIdentifier policyIdentifier,
     PartyId employerId,
     String coverageDetails,
     PolicyStatus status,
     PremiumSummary premiumSummary, Integer beneficiaryCount) {
        if(status == null) {
            status = PolicyStatus.INT;
        }
        if(beneficiaryCount < 20) {
            throw new IllegalArgumentException("health.policy.error.beneficiary.count.must.be.greater.than.20");
        }


        this.id = id;
        this.policyIdentifier = policyIdentifier;
        this.employerId = employerId;
        this.coverageDetails = coverageDetails;
        this.status = status;
        this.premiumSummary = premiumSummary;
        this.beneficiaryCount = beneficiaryCount;
    }


}
