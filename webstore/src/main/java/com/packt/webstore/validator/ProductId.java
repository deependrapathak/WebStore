package com.packt.webstore.validator;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ProductIdValidator.class)
@Documented
public @interface ProductId {
	String message() default "{com.packt.webstore.validator.ProductId.message}";
	Class<?>[] groups() default{};
	public abstract Class<? extends Payload>[] payload() default{};
}
