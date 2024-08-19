package com.hpc.totem_api.dto.errors;

import java.util.Optional;

public record ErrorDTO(String message, Optional<String> details) {
}
