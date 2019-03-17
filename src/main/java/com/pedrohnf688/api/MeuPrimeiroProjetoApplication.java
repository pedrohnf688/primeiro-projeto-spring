package com.pedrohnf688.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.pedrohnf688.entidades.Empresa;
import com.pedrohnf688.repositorio.EmpresaRepository;


@SpringBootApplication
//@ComponentScan({"com.pedrohnf688.repositorio"})
//@EntityScan("com.pedrohnf688.entidades")
public class MeuPrimeiroProjetoApplication {

	@Autowired
    private EmpresaRepository empresaRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}

  	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Empresa e = new Empresa();
			
			e.setRazaoSocial("pedrohnf688");
			e.setCnpj("43243242");
			
			this.empresaRepositorio.save(e);
			
			List<Empresa> empresas = empresaRepositorio.findAll();
			
			empresas.forEach(System.out::println);
						
	
		};
	}

}
