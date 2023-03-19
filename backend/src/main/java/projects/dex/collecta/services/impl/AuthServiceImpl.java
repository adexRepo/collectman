package projects.dex.collecta.services.impl;

import projects.dex.collecta.models.AuthRequest;
import projects.dex.collecta.models.AuthResponse;
import projects.dex.collecta.models.RegistRequest;
import projects.dex.collecta.services.AuthService;


public class AuthServiceImpl implements AuthService {

    // @Autowired
    // private UserBaseRepository userBaseRepository;

    // @Autowired
    // private ModelMapper modelMapper;

    @Override
    public AuthResponse registration(RegistRequest reqNewUser) {
        // Optional<UserBase> isExist = userBaseRepository.findByUsernameAndEmail(
        //         reqNewUser.getUsername(),
        //         reqNewUser.getEmail());
        // if (!isExist.isPresent()) {
        //     // two mail can have 2 username
        //     UserBase userEntity = modelMapper.map(reqNewUser, UserBase.class);
        //     UserBase storedUserDetails = userBaseRepository.save(userEntity);
        //     UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);
        //     return null;
        // } else {
        //     return null;
        // }
        return null;
    }

    @Override
    public AuthResponse authenticate(AuthRequest auth) {
        return null;
    }

}
