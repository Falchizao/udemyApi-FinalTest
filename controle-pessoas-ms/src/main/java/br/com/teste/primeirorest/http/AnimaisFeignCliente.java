package br.com.teste.primeirorest.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.teste.primeirorest.compartilhado.*;
import java.util.*;

@FeignClient(name = "controle-animais-ms")
public interface AnimaisFeignCliente {

    @GetMapping(path = "/api/animais/{dono}/lista")
    List<AnimalDto> obterAnimais(@PathVariable Integer dono); 


}
