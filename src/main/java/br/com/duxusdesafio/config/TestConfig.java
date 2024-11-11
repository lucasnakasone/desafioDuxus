package br.com.duxusdesafio.config;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repositories.ComposicaoTimeRepository;
import br.com.duxusdesafio.repositories.IntegranteRepository;
import br.com.duxusdesafio.repositories.TimeRepository;

/**
 * Classe de testes para inicialização de entidades no banco de testes H2
 */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ComposicaoTimeRepository composicaoTimeRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private IntegranteRepository integranteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Entidades inicializadas
		
		// Franquias
		final String franquiaDota = "DoTA";
		final String franquiaLoL = "LoL";
		final String franquiaCS = "Counter Strike";
		
		// Integrantes
		// DotA
		Integrante lucas = new Integrante(franquiaDota, "Lucas", "Carry", null); 
		Integrante igor = new Integrante(franquiaDota, "Igor", "Carry", null); 
		// LoL
		Integrante lara = new Integrante(franquiaLoL, "Lara", "Carry", null);
		// CS
		Integrante maiara = new Integrante(franquiaCS, "Maiara", "Suporte", null);
		integranteRepository.saveAll(Arrays.asList(lucas, igor, lara, maiara));
		
		// Times
		Time navi = new Time(LocalDate.of(1994, 1, 1), null); 
		Time alliance = new Time(LocalDate.of(1995, 1, 1), null); 
		Time psg = new Time(LocalDate.of(1996, 1, 1), null); 
		Time og = new Time(LocalDate.of(1996, 1, 1), null); 
		timeRepository.saveAll(Arrays.asList(navi, alliance, psg, og));
				
		// Composicao
		ComposicaoTime cp1 = new ComposicaoTime(navi, lucas);
		ComposicaoTime cp2 = new ComposicaoTime(alliance, igor);
		ComposicaoTime cp3 = new ComposicaoTime(psg, lara);
		ComposicaoTime cp4 = new ComposicaoTime(og, maiara);
		composicaoTimeRepository.saveAll(Arrays.asList(cp1, cp2, cp3, cp4));		
	}
	
}
