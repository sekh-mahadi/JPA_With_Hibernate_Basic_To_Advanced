package io.mtech.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PartTimeEmployee extends Employee{
	
private BigDecimal hourlyWage;

public PartTimeEmployee(String name, BigDecimal hourlyWage) {
	super(name);
	this.hourlyWage = hourlyWage;
}
}
