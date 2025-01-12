package br.com.davibelchior.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "O campo username não pode estar em branco")
    @Pattern(regexp = "\\S+", message = "O campo username não deve conter espaço")
    @Column(nullable = false, unique = true)
    private String username;

    @Email(message = "O campo email deve conter um e-mail válido")
    @NotBlank(message = "O campo email não pode estar em branco")
    @Column(nullable = false, unique = true)
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 50 caracteres")
    @NotBlank(message = "O campo senha não pode estar em branco")
    @Column(nullable = false)
    private String password;

    @Column
    private String website;

    @Column
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
