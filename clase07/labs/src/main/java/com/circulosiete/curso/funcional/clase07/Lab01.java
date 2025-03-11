package com.circulosiete.curso.funcional.clase07;

import java.math.BigDecimal;
import java.util.Optional;

public class Lab01 {
    public Optional<Cliente> buscarClienteOptionalEnDB(int id) {
        // se busca de alguna forma...
        return Optional.empty();
    }

    public Optional<BigDecimal> obtenerSaldo(Cliente cliente) {
        // se calcula de alguna forma cuando el cliente esta establecido
        return Optional.empty();

    }

    public BigDecimal calcularSaldoConOptional(int idCliente) {
        Optional<Optional<BigDecimal>> saldoOptionalDeOptional = this.buscarClienteOptionalEnDB(idCliente)
                .map(this::obtenerSaldo);

        Optional<BigDecimal> saldoOpcional = saldoOptionalDeOptional
                .orElseGet(Optional::empty);

        BigDecimal saldo = saldoOpcional
                .orElse(BigDecimal.ZERO);

        return saldo;
    }

    public BigDecimal calcularSaldoConFlatMap(int idCliente) {
        Optional<BigDecimal> saldoOpcional = this.buscarClienteOptionalEnDB(idCliente)
                .flatMap(this::obtenerSaldo);

        BigDecimal saldo = saldoOpcional.orElse(BigDecimal.ZERO);

        return saldo;
    }

    public Optional<BigDecimal> calcularSaldo(int idCliente) {
        return this.buscarClienteOptionalEnDB(idCliente)
                .flatMap(this::obtenerSaldo);
    }
}
