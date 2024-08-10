package br.com.fotoexpress.formalizacao.repository;

import br.com.fotoexpress.formalizacao.domain.entity.Formalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormalizacaoRepository extends JpaRepository<Formalizacao, Long> {

    @Query("select f from Formalizacao f where f.pedido.id = :pedidoId")
    Formalizacao buscaFormalizacaoPorPedidoId(@Param("pedidoId") Long pedidoId);

    @Query("select f from Formalizacao f where f.contratoId = :contratoId")
    Formalizacao buscaFormalizacaoPorContratoId(@Param("contratoId") String contratoId);
}
