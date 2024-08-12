package br.com.fotoexpress.formalizacao.model;

import br.com.fotoexpress.formalizacao.model.enums.StatusFormalizacao;
import br.com.fotoexpress.pedido.model.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="formalizacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataFormalizacao;
    private String contratoId;
    private StatusFormalizacao statusFormalizacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Pedido pedido;

    public void formalizar() {
        this.statusFormalizacao = StatusFormalizacao.FORMALIZADO;
        this.dataFormalizacao = LocalDateTime.now();
    }

    public boolean assinarContrato() {
        if (this.statusFormalizacao == StatusFormalizacao.FORMALIZADO) {
            this.statusFormalizacao = StatusFormalizacao.ASSINADO;
            return true;
        }
        return false;
    }
}
