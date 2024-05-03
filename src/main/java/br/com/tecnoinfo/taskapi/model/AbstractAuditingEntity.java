package br.com.tecnoinfo.taskapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity {

    @CreatedBy
    @Column(name = "inclusao_usuario", updatable = false, nullable = false, length = 50)
    private String inclusaoUsuario;

    @CreatedDate
    @Column(name = "inclusao_data", updatable = false)
    private Instant inclusaoData = Instant.now();

    @LastModifiedBy
    @Column(name = "alteracao_usuario", length = 50)
    private String usuarioAlteracao;

    @LastModifiedDate
    @Column(name = "alteracao_data")
    private Instant alteracaoData = Instant.now();
}
