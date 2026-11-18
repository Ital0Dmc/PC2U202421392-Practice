package pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.transform;

import pe.com.aseguramed.platform.u202421392.insurance.domain.model.aggregates.HealthPolicy;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources.HealthPolicyResource;

/**
 * Assembler that converts a {{aggregate}} aggregate into its response resource.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public class HealthPolicyResourceFromEntityAssembler {
    /**
     * Converts a {{aggregate}} aggregate into a response resource.
     *
     * @param entity the {{aggregate}} aggregate
     * @return the response resource
     */
    public static HealthPolicyResource toResourceFromEntity(HealthPolicy entity) {
        return new HealthPolicyResource(
                entity.getId(),
                entity.getPolicyIdentifier().value().toString(),
                entity.getEmployerId().value().toString(),
                entity.getCoverageDetails(),
                entity.getStatus().name(),
                entity.getPremiumSummary().basePremium(),
                entity.getPremiumSummary().eventDeductible(),
                entity.getPremiumSummary().pharmacyCoverageLimit(),
                entity.getBeneficiaryCount()
        );
    }
}
