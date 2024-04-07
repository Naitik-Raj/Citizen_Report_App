package in.naitik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.naitik.entity.CitizenPlan;
import in.naitik.request.SearchRequest;
import in.naitik.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController {

	@Autowired
	private ReportService repoService;

	@PostMapping("/search")
	public String handleSearch(SearchRequest request, Model model) {
		System.out.println(request);
		List<CitizenPlan> plans = repoService.search(request);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		init(model);
		return "index";
	}

	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";

		response.setHeader(headerKey, headerValue);

		repoService.generateExcel(response);
	}

	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";

		response.setHeader(headerKey, headerValue);

		repoService.generatePdf(response);
	}

	private void init(Model model) {
		model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", repoService.getPlanNames());
		model.addAttribute("status", repoService.getPlanStatus());
	}
}
