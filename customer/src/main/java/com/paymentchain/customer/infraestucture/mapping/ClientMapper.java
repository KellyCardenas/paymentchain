package com.paymentchain.customer.infraestucture.mapping;

import com.paymentchain.customer.application.dto.ClientDto;
import com.paymentchain.customer.domain.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "address", target = "address"),
    })
    ClientDto toClientDto(Client client);

    List<ClientDto> toClientsDto(List<Client> clients);

    @InheritInverseConfiguration
    Client toClient(ClientDto clientDto);
}
