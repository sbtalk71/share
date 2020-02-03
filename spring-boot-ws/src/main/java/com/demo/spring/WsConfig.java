package com.demo.spring;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WsConfig {

	@Bean
	public ServletRegistrationBean messsageDispatcherServlet(ApplicationContext ctx) {
		MessageDispatcherServlet mds = new MessageDispatcherServlet();
		mds.setApplicationContext(ctx);
		mds.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(mds, "/ws/*");
	}

	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/calculator.xsd"));
	}

	@Bean("calculator")
	public Wsdl11Definition wsdldef(XsdSchema xsdSchema) {
		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
		wsdl.setTargetNamespace("http://ws.spring.demo.com/calculator");
		wsdl.setLocationUri("/ws");
		wsdl.setPortTypeName("CalculatorPort");
		wsdl.setSchema(xsdSchema);
		return wsdl;
	}
}
