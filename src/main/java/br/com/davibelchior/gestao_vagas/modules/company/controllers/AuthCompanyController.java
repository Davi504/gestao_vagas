package br.com.davibelchior.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.davibelchior.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.davibelchior.gestao_vagas.modules.company.useCases.AuthCompanyUseCase;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var result = this.authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario/Senha incorreta");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor: " + e.getMessage());
        }
    }
}
