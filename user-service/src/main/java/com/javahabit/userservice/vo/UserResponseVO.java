package com.javahabit.userservice.vo;

import com.javahabit.userservice.domain.User;

public record UserResponseVO(User user,Error error) {

}
