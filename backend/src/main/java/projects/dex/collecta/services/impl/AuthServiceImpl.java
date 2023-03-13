package projects.dex.collecta.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import projects.dex.collecta.models.dto.UserDto;
import projects.dex.collecta.models.entity.UserBase;
import projects.dex.collecta.repository.UserBaseRepository;
import projects.dex.collecta.services.AuthService;

public class AuthServiceImpl implements AuthService  {

    @Autowired
    private UserBaseRepository userBaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto registration(UserDto reqNewUser)
    {
        long isExit = userBaseRepository.countByEmail(reqNewUser.getEmail());
        if(isExit != 0 ){
            UserBase userEntity = modelMapper.map(reqNewUser, UserBase.class);
            UserBase storedUserDetails = userBaseRepository.save(userEntity);
            UserDto returnValue  = modelMapper.map(storedUserDetails, UserDto.class);
            return returnValue;
        }else{
            return reqNewUser;
        }
    }

    
}
