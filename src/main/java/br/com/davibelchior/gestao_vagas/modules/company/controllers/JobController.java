package br.com.davibelchior.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.davibelchior.gestao_vagas.modules.company.entities.JobEntity;
import br.com.davibelchior.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity, HttpServletRequest request) {

        var companyId = request.getAttribute("company_id");

        jobEntity.setCompanyId(UUID.fromString(companyId.toString()));

        return this.createJobUseCase.execute(jobEntity);
    }
}
