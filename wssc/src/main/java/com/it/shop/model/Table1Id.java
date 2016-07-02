package com.it.shop.model;

/**
 * Table1Id entity. @author MyEclipse Persistence Tools
 */

public class Table1Id implements java.io.Serializable {

	// Fields

	private String a;
	private String b;
	private String c;
	private String d;

	// Constructors

	/** default constructor */
	public Table1Id() {
	}

	/** full constructor */
	public Table1Id(String a, String b, String c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	// Property accessors

	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Table1Id))
			return false;
		Table1Id castOther = (Table1Id) other;

		return ((this.getA() == castOther.getA()) || (this.getA() != null
				&& castOther.getA() != null && this.getA().equals(
				castOther.getA())))
				&& ((this.getB() == castOther.getB()) || (this.getB() != null
						&& castOther.getB() != null && this.getB().equals(
						castOther.getB())))
				&& ((this.getC() == castOther.getC()) || (this.getC() != null
						&& castOther.getC() != null && this.getC().equals(
						castOther.getC())))
				&& ((this.getD() == castOther.getD()) || (this.getD() != null
						&& castOther.getD() != null && this.getD().equals(
						castOther.getD())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getA() == null ? 0 : this.getA().hashCode());
		result = 37 * result + (getB() == null ? 0 : this.getB().hashCode());
		result = 37 * result + (getC() == null ? 0 : this.getC().hashCode());
		result = 37 * result + (getD() == null ? 0 : this.getD().hashCode());
		return result;
	}

}