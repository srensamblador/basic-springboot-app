package com.srensamblador.springapp.configuration;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Implementa un serializador de campos que representan cantidades de dinero. Se
 * asegura de que valores {@link BigDecimal} sean representados con dos
 * decimales.
 * 
 * Para indicar que una propiedad de un DTO utiliza este serializador se puede
 * utilizar la anotación {@code @JsonSerialize(using=MoneySerializer.class)}
 * 
 * @author Samuel
 *
 */
public class MoneySerializer extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.setScale(2).toString());
	}

}
