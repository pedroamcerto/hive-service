package com.hive.utils.mission;

import com.hive.domain.CarbonCredit;
import com.hive.dto.carbonCredit.GetCarbonCredit;
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
     * Este método é usado quando a lista contém objetos do tipo `CarbonCredit`.
     *
     * @param carbonCredits Lista de créditos de carbono do tipo `CarbonCredit`.
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

    /**
     * Calcula o total de toneladas de carbono associadas a uma lista de numeros de créditos de carbono.
     * Este método é usado quando a lista contém objetos do tipo `Double`.
     *
     * @param carbonCredits Lista de valores de créditos de carbono do tipo `Double`.
     * @return O total de toneladas de carbono somado a partir dos créditos de carbono fornecidos.
     */
    public Double calculateTotalTon(Double[] carbonCredits) {
        Double totalTon = 0.0;

        // Itera sobre cada crédito de carbono e soma o valor de carbono
        for (Double carbonCredit : carbonCredits) {
            totalTon += carbonCredit;
        }

        return totalTon;
    }


}
