package pe.com.aseguramed.platform.u202421392.insurance.domain.aggregates;

import lombok.Getter;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PartyId;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.valueobjects.PolicyIdentifier;
import pe.com.aseguramed.platform.u202421392.shared.domain.model.valueobjects.PremiumSummary;

@Getter
public class HealthPolicy {
    private Long id;
    private PolicyIdentifier policyIdentifier;
    private PartyId employerId;
    private String coverageDetails;
    private PolicyStatus status;
    private PremiumSummary premiumSummary;
}
