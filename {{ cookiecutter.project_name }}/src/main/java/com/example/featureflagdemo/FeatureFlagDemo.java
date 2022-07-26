package com.example.featureflagdemo;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.util.UnleashConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagDemo {

	private Unleash unleash;

	public FeatureFlagDemo(){
		UnleashConfig config = UnleashConfig
			.builder()
			.appName({{ cookiecutter.app_name }})
			.unleashAPI({{ cookiecutter.unleash_api_url }})
			.instanceId({{ cookiecutter.unleash_api_instance_id }})
			.build();

		unleash = new DefaultUnleash(config);
	}

	@Scheduled(fixedDelay = 1000)
	public void testMethod(){
		if (unleash.isEnabled("flag_a")){
			System.out.println("Flag A is enabled!");
		} else {
			System.out.println("Flag A is disabled!");
		}
	}
}
