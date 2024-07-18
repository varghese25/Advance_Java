package com.varghese.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varghese.restapi.entity.Student;

public interface StudentRespository extends JpaRepository <Student, Integer>{

}
