package com.shopesimple.invManager.DTO;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String emailId;
    private Set<Role> roles = new HashSet<>();

//    public static UserDto from(User  user){
//        UserDto userDto = new UserDto();
//        userDto.setEmailId(user.getEmailId());
//        userDto.setRoles(user.getRoles());
//
//        return userDto;
//    }

}
