package com.example.springcoredojo;

import com.example.springcoredojo.EntidadesAlumno.Config;
import com.example.springcoredojo.EntidadesAlumno.Usuario;
import com.example.springcoredojo.EntidadesYoutuber.Youtuber;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreDojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDojoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			creacionBeansAlumno();
			creacionBeansYoutuber();
			creacionBeansAlumnoXML();
		};
}

	private void creacionBeansAlumno() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Usuario usuarioGeneradoPorBen = context.getBean("usuario",Usuario.class);
		System.out.println("Usuario: " + usuarioGeneradoPorBen);
	}

	private void creacionBeansYoutuber() {
		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
		Youtuber youtuber = context.getBean(Youtuber.class);
		System.out.println(" ");
		System.out.println("Youtuber: " + youtuber.getNombre() );

	}
	private void creacionBeansAlumnoXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext("alumno-bean-config.xml");
		Usuario u = (Usuario) context.getBean("usuario");
		System.out.println(" ");
		System.out.println("Alumna: " + u.getAlumno().getNombre()  + " " + u.getAlumno().getApellido());
		System.out.println("Edad: " + u.getAlumno().getEdad() + " years.");
	}

}