package pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources;

import java.math.BigDecimal;

public record HealthPolicyResource(
        Long id,
        String policyId,
        String employerId,
        String coverageDetails,
        String status,
        BigDecimal basePremium,
        BigDecimal eventDeductible,
        BigDecimal pharmacyCoverageLimit,
        Integer beneficiaryCount
) {
}
