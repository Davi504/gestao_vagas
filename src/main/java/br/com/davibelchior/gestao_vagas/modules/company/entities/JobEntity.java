package br.com.davibelchior.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String description;

    @NotBlank(message = "Esse campo é obrigatório")
    @Column(nullable = false)
    private String level;

    @Column
    private String benefits;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity companyEntity;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public void setCompanyId(UUID companyId) {
        this.companyEntity = new CompanyEntity();
        this.companyEntity.setId(companyId);
    }
}
