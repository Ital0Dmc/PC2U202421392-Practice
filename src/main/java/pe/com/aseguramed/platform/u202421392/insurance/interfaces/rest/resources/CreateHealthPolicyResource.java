package pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Resource with the request data to create a {{aggregate}}.
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
public record CreateHealthPolicyResource(@NotNull UUID policyIdentifier,
                                         @NotNull UUID employerId,
                                         String coverageDetails,
                                         PolicyStatus status,
                                         @NotNull BigDecimal basePremium,
                                         @NotNull BigDecimal eventDeductible,
                                         @NotNull BigDecimal pharmacyCoverageLimit,
                                         @NotNull Integer beneficiaryCount) {
}
