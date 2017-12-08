package org.sneha.restapi.messenger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {


	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rowtype, Type genericType,
			Annotation[] annotations) {
		// TODO Auto-generated method stub
		if(rowtype.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {
				
			@Override
			public T fromString(String value) {
				Calendar requestedDate = Calendar.getInstance();
				if("tomorrow".equalsIgnoreCase(value)) {
					requestedDate.add(Calendar.DATE, 1);
				}	
				else if("yesterday".equalsIgnoreCase(value)) {
					requestedDate.add(Calendar.DATE, -1);
				}
				MyDate mydate = new MyDate();
				mydate.setDate(requestedDate.get(Calendar.DATE));
				mydate.setMonth(requestedDate.get(Calendar.MONTH));
				mydate.setYear(requestedDate.get(Calendar.YEAR));	
				
				return rowtype.cast(mydate);
				
			}

			@Override
			public String toString(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
				
				
			}; //return
		} //if
		return null;
	} //method
}
