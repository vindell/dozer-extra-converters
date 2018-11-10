package com.github.dozermapper.extra.converters.number;

import java.math.BigInteger;

import org.apache.commons.beanutils.converters.BigIntegerConverter;

import com.github.dozermapper.core.CustomConverter;
import com.github.dozermapper.core.MappingException;

public final class BigIntegerStringConverter implements CustomConverter {
	
	private final BigIntegerConverter converter = new BigIntegerConverter();
     
	/**
	 * 转换接口实现 
	 * @param destinationFieldValue：目标字段值
	 * @param sourceFieldValue：源字段值
	 * @param destinationClass:目标字段类型
	 * @param sourceClass：源字段类型
	 * @return 转换后的结果
	 */
	public Object convert(Object destinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
		if (sourceFieldValue == null) {
			return null;
		}
		//String to BigInteger
		if (sourceClass.equals(String.class)&&sourceFieldValue instanceof String) {
			return converter.convert(String.class, sourceFieldValue);
		}
		//BigInteger to String
		if (sourceClass.equals(BigInteger.class)&&sourceFieldValue instanceof BigInteger) {
			return ((BigInteger) sourceFieldValue).toString();
		}
		throw new MappingException( "Converter BigIntegerStringConverter used incorrectly. Arguments passed in were:" + destinationFieldValue + " and " + sourceFieldValue);
	}
}