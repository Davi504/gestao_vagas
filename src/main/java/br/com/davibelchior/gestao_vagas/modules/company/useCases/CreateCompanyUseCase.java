package br.com.davibelchior.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.davibelchior.gestao_vagas.exceptions.UserFoundException;
import br.com.davibelchior.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.davibelchior.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    private final CompanyRepository companyRepository;

    @Autowired
    public CreateCompanyUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}
