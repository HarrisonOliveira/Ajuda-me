package com.estudo.ajudame.repository;

import model.Ong;

public interface IOngRepository {
    Ong salvar(Ong ong);
    Ong deletar(Ong ong);
}
