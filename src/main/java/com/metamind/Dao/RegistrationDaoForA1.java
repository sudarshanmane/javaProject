package com.metamind.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metamind.model.Registration;

public interface RegistrationDaoForA1 extends JpaRepository<Registration, Integer>{

	public List<Registration> getByDistrict(String district);
}
