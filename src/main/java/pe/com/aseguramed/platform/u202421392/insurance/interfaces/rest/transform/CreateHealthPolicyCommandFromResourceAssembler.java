package pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.transform;

import pe.com.aseguramed.platform.u202421392.insurance.domain.model.commands.CreateHealthPolicyCommand;
import pe.com.aseguramed.platform.u202421392.insurance.domain.model.enums.PolicyStatus;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources.CreateHealthPolicyResource;

/**
 * Assembler that converts a create resource into a create command of a {{aggregate}}.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
public class CreateHealthPolicyCommandFromResourceAssembler {
    /**
     * Converts a create resource into a create command.
     *
     * @param resource the create resource
     * @return the create command
     */
    public static CreateHealthPolicyCommand toCommandFromResource(
            CreateHealthPolicyResource resource) {
        return new CreateHealthPolicyCommand(
                resource.policyIdentifier(),
                resource.employerId(),
                resource.coverageDetails(),
                resource.status(),
                resource.basePremium(),
                resource.eventDeductible(),
                resource.pharmacyCoverageLimit(),
                resource.beneficiaryCount()
        );
    }
}
