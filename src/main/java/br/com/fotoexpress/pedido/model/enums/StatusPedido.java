package br.com.fotoexpress.pedido.model.enums;

import br.com.fotoexpress.exceptions.PedidoException;

public enum StatusPedido {

    EM_ANDAMENTO (0,"Em andamento"),
    AGENDADO(1, "Agendado"),
    CANCELADO (2,"Cancelado"),
    CONCLUIDO (3,"Concluído"),
    AGENDAR(4, "Agendar")
    ;

    private final int id;
    private final String descricao;

    StatusPedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static StatusPedido getById(int id) {
        for (StatusPedido status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new PedidoException("Id inválido para Status: " + id);
    }

    public static String getDescricaoById(int id) {
        StatusPedido status = getById(id);
        return status.getDescricao();
    }
}

