package pe.com.aseguramed.platform.u202421392.insurance.domain.exceptions;

public class HealthPolicyAlreadyExistsException extends RuntimeException {
    public HealthPolicyAlreadyExistsException() {
        super("health.policy.error.duplicate.policy.identifier");
    }
}
