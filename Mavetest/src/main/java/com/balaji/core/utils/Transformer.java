package com.balaji.core.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.sun.xml.bind.v2.schemagen.xmlschema.Annotation;

public class Transformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class arg1, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub
		
		annotation.setRetryAnalyzer(RetryTestcase.class);
		
	}

}
