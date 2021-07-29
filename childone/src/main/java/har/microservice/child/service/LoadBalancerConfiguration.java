/**
 * 
 */
package har.microservice.child.service;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harshadnelwadkar
 *
 */
@Configuration
public class LoadBalancerConfiguration {
	
	 @Bean
	   public ServiceInstanceListSupplier
	discoveryClientServiceInstanceListSupplier(
	         ConfigurableApplicationContext context) {
	      System.out.println("Configuring Load balancer to prefer same instance");
	      return ServiceInstanceListSupplier.builder()
	               .withBlockingDiscoveryClient()
	               .withSameInstancePreference()
	               .build(context);
	      }
	}