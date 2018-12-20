package com.workproject.algamoney.api.event.listener;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workproject.algamoney.api.event.RecursoCriadoEvent;

@Component
public class RecursoEventListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(event.getCodigo()).toUri();
		event.getResponse().setHeader("Location", uri.toASCIIString());
	}

}
