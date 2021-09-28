package br.edu.infnet.UsuarioVenturaHR;

import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Endereco;
import br.edu.infnet.UsuarioVenturaHR.service.usuarios.ViaCEPClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class UsuarioVenturaHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioVenturaHrApplication.class, args);
	}
        
    @Bean
    public CommandLineRunner run(ViaCEPClient client){
        return args -> {
            if (args.length > 0) {
                String cep = args[0];
 
                Endereco endereco = client.buscaEnderecoPor(cep);
 
                System.out.println(endereco);
            }
        };
        
    }

}
