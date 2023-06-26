package com.app.backend.mapper;

import com.app.backend.model.entity.Account;
import com.app.backend.model.entity.AccountEmail;
import com.app.backend.model.entity.AccountInfo;
import com.app.backend.model.request.AccountRegister;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    Account from(AccountRegister register);
    AccountEmail fromEmail(AccountRegister register);
    AccountInfo fromInfo(AccountRegister register);
}
