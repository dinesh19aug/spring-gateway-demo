package com.javahabit.userservice.domain;

import java.util.Date;

public record User(int id, String firstName, String lastname, Date dateOfBirth, int department) {
}


