package io.mosip.kernel.auditmanager.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Base class for {@link Audit} with {@link #uuid} and {@link #createdAt}
 * 
 * @author Dharmesh Khandelwal
 * @since 1.0.0
 *
 */
@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseAudit {

	/**
	 * Field for immutable universally unique identifier (UUID)
	 */
	@Id
	@Column(name = "log_id", nullable = false, updatable = false)
	private String uuid;

	@Column(name = "log_dtimes", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	/**
	 * Constructor to initialize {@link BaseAudit} with uuid and timestamp
	 */
	public BaseAudit() {
		uuid = UUID.randomUUID().toString();
		createdAt = LocalDateTime.now();
	}

}
