package com.example.server.service;

import com.example.server.domain.Data;
import com.example.server.model.DataDTO;
import com.example.server.repos.DataRepository;
import com.example.server.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(final DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataDTO> findAll() {
        final List<Data> datas = dataRepository.findAll(Sort.by("id"));
        return datas.stream()
                .map(data -> mapToDTO(data, new DataDTO()))
                .toList();
    }

    public DataDTO get(final String id) {
        return dataRepository.findById(id)
                .map(data -> mapToDTO(data, new DataDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public String create(final DataDTO dataDTO) {
        final Data data = new Data();
        mapToEntity(dataDTO, data);
        data.setId(dataDTO.getId());
        return dataRepository.save(data).getId();
    }

    public void update(final String id, final DataDTO dataDTO) {
        final Data data = dataRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(dataDTO, data);
        dataRepository.save(data);
    }

    public void delete(final String id) {
        dataRepository.deleteById(id);
    }

    private DataDTO mapToDTO(final Data data, final DataDTO dataDTO) {
        dataDTO.setId(data.getId());
        dataDTO.setEndYear(data.getEndYear());
        dataDTO.setIntensity(data.getIntensity());
        dataDTO.setSector(data.getSector());
        dataDTO.setTopic(data.getTopic());
        dataDTO.setInsight(data.getInsight());
        dataDTO.setUrl(data.getUrl());
        dataDTO.setRegion(data.getRegion());
        dataDTO.setStartYear(data.getStartYear());
        dataDTO.setImpact(data.getImpact());
        dataDTO.setAdded(data.getAdded());
        dataDTO.setPublished(data.getPublished());
        dataDTO.setCountry(data.getCountry());
        dataDTO.setRelevance(data.getRelevance());
        dataDTO.setPestle(data.getPestle());
        dataDTO.setSource(data.getSource());
        dataDTO.setTitle(data.getTitle());
        dataDTO.setLikelihood(data.getLikelihood());
        return dataDTO;
    }

    private Data mapToEntity(final DataDTO dataDTO, final Data data) {
        data.setEndYear(dataDTO.getEndYear());
        data.setIntensity(dataDTO.getIntensity());
        data.setSector(dataDTO.getSector());
        data.setTopic(dataDTO.getTopic());
        data.setInsight(dataDTO.getInsight());
        data.setUrl(dataDTO.getUrl());
        data.setRegion(dataDTO.getRegion());
        data.setStartYear(dataDTO.getStartYear());
        data.setImpact(dataDTO.getImpact());
        data.setAdded(dataDTO.getAdded());
        data.setPublished(dataDTO.getPublished());
        data.setCountry(dataDTO.getCountry());
        data.setRelevance(dataDTO.getRelevance());
        data.setPestle(dataDTO.getPestle());
        data.setSource(dataDTO.getSource());
        data.setTitle(dataDTO.getTitle());
        data.setLikelihood(dataDTO.getLikelihood());
        return data;
    }

    public boolean idExists(final String id) {
        return dataRepository.existsByIdIgnoreCase(id);
    }

}
