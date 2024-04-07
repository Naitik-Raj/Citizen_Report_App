package in.naitik.service;

import java.util.List;

import in.naitik.entity.CitizenPlan;
import in.naitik.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response)throws Exception;

	public void generatePdf(HttpServletResponse response) throws Exception;
}
