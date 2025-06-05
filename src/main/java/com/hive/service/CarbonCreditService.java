package com.hive.service;

import com.hive.core.exception.BadRequestException;
import com.hive.core.exception.NotFoundException;
import com.hive.domain.CarbonCredit;
import com.hive.domain.Mission;
import com.hive.domain.enumerated.MissionStatus;
import com.hive.domain.interfaces.ServiceInterface;
import com.hive.dto.carbonCredit.CreateCarbonCreditDto;
import com.hive.dto.carbonCredit.GetCarbonCredit;
import com.hive.repository.CarbonCreditRepository;
import com.hive.repository.MissionRepository;
import com.hive.utils.mission.MissionUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela gestão de créditos de carbono. Implementa operações relacionadas à criação, leitura e gerenciamento de créditos de carbono em missões.
 */
@Service
@RequiredArgsConstructor
public class CarbonCreditService implements ServiceInterface<GetCarbonCredit, CreateCarbonCreditDto> {

    private final CarbonCreditRepository carbonCreditRepository;
    private final MissionRepository missionRepository;
    private final ModelMapper modelMapper;
    private final MissionUtils missionUtils;

    /**
     * Cria um novo crédito de carbono e associa-o a uma missão ativa.
     *
     * @param createCarbonCreditDto DTO contendo os dados do crédito de carbono a ser criado.
     * @throws NotFoundException Se a missão não for encontrada no banco de dados.
     * @throws BadRequestException Se a missão não estiver ativa ou já tiver atingido sua meta de créditos.
     */
    public void create(CreateCarbonCreditDto createCarbonCreditDto) {
        Mission mission =  missionRepository.findById(createCarbonCreditDto.getMission().getId())
                .orElseThrow(() -> new NotFoundException("Missão não encontrada"));

        // Verifica se a missão está ativa
        if(!mission.getStatus().equals(MissionStatus.ACTIVE)){
            throw new BadRequestException("Não é possível associar créditos a uma missão com status diferente de ativo.");
        }

        // Verifica se a missão já atingiu a meta de créditos
        if(missionUtils.calculateTotalTon(mission.getCarbonCredits()) >= mission.getTotalTon()) {
            throw new BadRequestException("A missão já concluiu a meta de créditos");
        }

        CarbonCredit carbonCredit = modelMapper.map(createCarbonCreditDto, CarbonCredit.class);

        mission.getCarbonCredits().add(carbonCredit);

        // Atualiza o status da missão caso tenha atingido a meta de créditos
        if(missionUtils.calculateTotalTon(mission.getCarbonCredits()) >= mission.getTotalTon()) {
            mission.setStatus(MissionStatus.COMPLETED);
        }

        carbonCreditRepository.save(carbonCredit);
    }

    /**
     * Atualiza um crédito de carbono.
     *
     * @param id O ID do crédito de carbono a ser atualizado.
     * @param entity DTO com os dados atualizados do crédito de carbono.
     * @throws UnsupportedOperationException Este método não é suportado para créditos de carbono, pois não é possível atualizá-los.
     */
    @Override
    public void update(Long id, CreateCarbonCreditDto entity) {
        // Não é possível atualizar um crédito
        throw new UnsupportedOperationException("Não é possível atualizar um crédito de carbono.");
    }

    /**
     * Recupera todos os créditos de carbono.
     *
     * @return Uma lista de DTOs contendo os dados de todos os créditos de carbono.
     */
    public List<GetCarbonCredit> getAll() {
        return carbonCreditRepository.findAll().stream()
                .map(carbonCredit -> modelMapper.map(carbonCredit, GetCarbonCredit.class))
                .collect(Collectors.toList());
    }

    /**
     * Deleta um crédito de carbono.
     *
     * @param id O ID do crédito de carbono a ser deletado.
     * @throws UnsupportedOperationException Este método não é suportado, pois não é possível deletar créditos de carbono.
     */
    @Override
    public void delete(Long id) {
        // Não é possível deletar um crédito.
        throw new UnsupportedOperationException("Não é possível deletar um crédito de carbono.");
    }

    /**
     * Recupera um crédito de carbono pelo seu ID.
     *
     * @param id O ID do crédito de carbono a ser recuperado.
     * @return Um DTO contendo os dados do crédito de carbono recuperado.
     * @throws NotFoundException Se o crédito de carbono não for encontrado no banco de dados.
     */
    public GetCarbonCredit getById(Long id) {
        CarbonCredit carbonCredit = carbonCreditRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Crédito de carbono não encontrado"));
        return modelMapper.map(carbonCredit, GetCarbonCredit.class);
    }
}
