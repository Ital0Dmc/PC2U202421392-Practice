package pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.aseguramed.platform.u202421392.insurance.domain.services.HealthPolicyCommandService;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources.CreateHealthPolicyResource;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.resources.HealthPolicyResource;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.transform.CreateHealthPolicyCommandFromResourceAssembler;
import pe.com.aseguramed.platform.u202421392.insurance.interfaces.rest.transform.HealthPolicyResourceFromEntityAssembler;

/**
 * REST controller that exposes the {{aggregate}} endpoints.
 *
 * @author Italo Gianfranco Damacen Galindo
 */
@Tag(name = "Health Policies", description = "HealthPolicy Management Endpoints")
@RestController
@RequestMapping("/api/v1/health-policies")
public class HealthPoliciesController {

    private final HealthPolicyCommandService healthPolicyCommandService;

    public HealthPoliciesController(HealthPolicyCommandService healthPolicyCommandService) {
        this.healthPolicyCommandService = healthPolicyCommandService;
    }
    /**
     * Creates a new {{aggregate}}.
     *
     * @param resource the create resource
     * @return the created {{aggregate}} resource with HTTP status 201
     */
    @PostMapping
    @Operation(summary = "Create a healthPolicy")
    @ApiResponse(responseCode = "201", description = "HealthPolicy created")
    public ResponseEntity<HealthPolicyResource> createHealthPolicy(
            @Valid @RequestBody CreateHealthPolicyResource resource) {
        var command = CreateHealthPolicyCommandFromResourceAssembler
                .toCommandFromResource(resource);
        var healthPolicy = healthPolicyCommandService.handle(command);
        var response = HealthPolicyResourceFromEntityAssembler
                .toResourceFromEntity(healthPolicy);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
