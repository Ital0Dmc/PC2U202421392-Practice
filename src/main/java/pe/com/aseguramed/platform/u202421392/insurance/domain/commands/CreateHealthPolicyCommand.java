package pe.com.aseguramed.platform.u202421392.insurance.domain.commands;

import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;

import java.math.BigDecimal;
import java.util.UUID;
/**
 * Command with the data required to create a {{aggregate}}.
 *
 * @param policyIdentifier    the code
 * @param employerId          the identifier from another bounded context
 * @param status            the initial status
 * @param basePremium        the first amount
 * @param eventDeductible   the second amount
 * @param pharmacyCoverageLimit the third amount
 * @param beneficiaryCount   the quantity
 * @author Italo Gianfranco Damacen Galindo
 */
public record CreateHealthPolicyCommand(
        UUID policyIdentifier,
        UUID employerId,
        String coverageDetails,
        PolicyStatus status,
        BigDecimal basePremium, BigDecimal eventDeductible,
        BigDecimal pharmacyCoverageLimit,
        Integer beneficiaryCount
) {
}
