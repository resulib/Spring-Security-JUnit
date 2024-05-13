package com.resul.springsecuritycaptcha.mapper;

import com.resul.springsecuritycaptcha.dto.UserDTO;
import com.resul.springsecuritycaptcha.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(UserEntity userEntity);
    List<UserDTO> toUserDTOList(List<UserEntity> userEntities);
}
