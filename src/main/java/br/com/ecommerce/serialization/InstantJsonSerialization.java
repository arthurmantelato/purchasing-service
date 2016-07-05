package br.com.ecommerce.serialization;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class InstantJsonSerialization {

	public static class InstantSerializer extends JsonSerializer<Instant> {
		@Override
		public void serialize(Instant arg0, JsonGenerator arg1, SerializerProvider arg2)
				throws IOException, JsonProcessingException {
			arg1.writeString(arg0.toString());
		}
	}
	
	public static class InstantDeserializer extends JsonDeserializer<Instant> {
		@Override
		public Instant deserialize(JsonParser arg0, DeserializationContext arg1)
				throws IOException, JsonProcessingException {
			// TODO Auto-generated method stub
			return Instant.parse(arg0.getText());
		}
		
	}

}
