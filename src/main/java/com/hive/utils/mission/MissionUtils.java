package com.hive.utils.mission;

import com.hive.domain.CarbonCredit;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe utilitária para operações relacionadas a missões de créditos de carbono.
 * Esta classe contém métodos para realizar cálculos específicos para missões,
 * como calcular o total de toneladas de carbono associadas aos créditos de carbono.
 */
@Component
public class MissionUtils {

    /**
     * Calcula o total de toneladas de carbono associadas a uma lista de créditos de carbono.
     *
     * @param carbonCredits Lista de créditos de carbono.
     * @return O total de toneladas de carbono somado a partir dos créditos de carbono fornecidos.
     */
    public Double calculateTotalTon(List<CarbonCredit> carbonCredits) {
        Double totalTon = 0.0;

        // Itera sobre cada crédito de carbono e soma o valor de carbono
        for (CarbonCredit carbonCredit : carbonCredits) {
            totalTon += carbonCredit.getCarbonTon();
        }

        return totalTon;
    }
}
