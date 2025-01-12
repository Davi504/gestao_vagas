package br.com.davibelchior.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.davibelchior.gestao_vagas.exceptions.UserFoundException;
import br.com.davibelchior.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.davibelchior.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CreateCandidateUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Transactional
    public CandidateEntity execute(CandidateEntity candidateEntity) {
        candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return candidateRepository.save(candidateEntity);
    }
}
