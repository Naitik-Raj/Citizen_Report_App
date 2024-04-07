package in.naitik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.naitik.entity.CitizenPlan;
import in.naitik.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		CitizenPlan entity1 = new CitizenPlan();
		entity1.setCitizenId(1);
		entity1.setName("John");
		entity1.setMobile(1234555l);
		entity1.setGender("Male");
		entity1.setSsn(68686868l);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");
		repo.save(entity1);

		CitizenPlan entity2 = new CitizenPlan();
		entity2.setCitizenId(2);
		entity2.setName("Smith");
		entity2.setMobile(32555l);
		entity2.setGender("Male");
		entity2.setSsn(6862368l);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);
		
		CitizenPlan entity3 = new CitizenPlan();
		entity3.setCitizenId(3);
		entity3.setName("Robert");
		entity3.setMobile(32555l);
		entity3.setGender("Male");
		entity3.setSsn(6862368l);
		entity3.setPlanName("Medicaid");
		entity3.setPlanStatus("Closed");
		repo.save(entity3);
	}

}
