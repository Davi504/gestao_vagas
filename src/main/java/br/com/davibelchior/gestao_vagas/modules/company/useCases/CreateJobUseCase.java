package br.com.davibelchior.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.davibelchior.gestao_vagas.modules.company.entities.JobEntity;
import br.com.davibelchior.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;

    @Autowired
    public CreateJobUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Transactional
    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
