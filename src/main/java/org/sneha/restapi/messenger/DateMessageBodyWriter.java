package org.sneha.restapi.messenger;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3,
			MediaType arg4) {
	//deprecated method, just return -1
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type arg1, Annotation[] annotations,
			MediaType arg3) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date date,
			Class<?> type,
			Type type1,
			Annotation[] antns,
			MediaType arg4,
			MultivaluedMap<String, Object> mm,
			OutputStream out) throws IOException, WebApplicationException {
	
		out.write(date.toString().getBytes());
	}

	
}
