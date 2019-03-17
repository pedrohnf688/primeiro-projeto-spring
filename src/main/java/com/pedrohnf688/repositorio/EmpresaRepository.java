package com.pedrohnf688.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrohnf688.entidades.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);

}
