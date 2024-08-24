package org.hibernate.bugs;

import jakarta.persistence.Embeddable;

@Embeddable
public class Route {

	private String origin;
	private String destination;

	public Route() {
	}

	public Route(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
}
