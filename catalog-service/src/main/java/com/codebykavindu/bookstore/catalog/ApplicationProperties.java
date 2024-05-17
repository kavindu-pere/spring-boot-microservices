package com.codebykavindu.bookstore.catalog;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * @author Kavindu Perera
 */
@ConfigurationProperties(prefix = "catalog")
public record ApplicationProperties(
        @DefaultValue("10")
        @Min(1)
        int pageSize
) {
}
