package com.georgiana.certification.convertor;

public interface Convertor <S, T>{
	
	T convert (S source);

}
