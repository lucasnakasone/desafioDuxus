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
		Integrante i1 = new Integrante("dota", "lucas", "carry", null); 
		Integrante i2 = new Integrante("lol", "igor", "carry", null); 
		Integrante i3 = new Integrante("nw", "lara", "carry", null);
		Integrante i4 = new Integrante("nw", "maiara", "suporte", null);
		Integrante i5 = new Integrante("nw", "mario", "mid", null);
		integranteRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5));
		
		Time t1 = new Time(LocalDate.of(1994, 1, 1), null); 
		Time t2 = new Time(LocalDate.of(1995, 1, 1), null); 
		Time t3 = new Time(LocalDate.of(1996, 1, 1), null); 
		Time t4 = new Time(LocalDate.of(1996, 1, 1), null); 
		Time t5 = new Time(LocalDate.of(1996, 1, 1), null); 
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
				
		ComposicaoTime cp1 = new ComposicaoTime(t1, i1);
		ComposicaoTime cp2 = new ComposicaoTime(t1, i2);
		ComposicaoTime cp3 = new ComposicaoTime(t1, i3);
		ComposicaoTime cp4 = new ComposicaoTime(t2, i1);
		ComposicaoTime cp5 = new ComposicaoTime(t2, i2);
		ComposicaoTime cp6 = new ComposicaoTime(t3, i1);
		ComposicaoTime cp7 = new ComposicaoTime(t3, i3);
		ComposicaoTime cp8 = new ComposicaoTime(t3, i4);
		ComposicaoTime cp9 = new ComposicaoTime(t3, i5);
		composicaoTimeRepository.saveAll(Arrays.asList(cp1, cp2, cp3, cp4, cp5, cp6, cp7, cp8, cp9));		
	}
	
}
