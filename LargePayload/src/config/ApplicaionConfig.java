package config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import service.LargePayloadService;

@ApplicationPath("rs")
public class ApplicaionConfig extends Application {
	
	private final Set<Class<?>> classes;

	public ApplicaionConfig() {
		HashSet<Class<?>> c = new HashSet<>();
		c.add(LargePayloadService.class);
		c.add(MOXyJsonProvider.class);
		classes = Collections.unmodifiableSet(c);
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}
}
